/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.output.mongodb;

import com.pragma.trazabilidad.domain.model.EficienciaEmpleado;
import com.pragma.trazabilidad.domain.model.EficienciaPedido;
import com.pragma.trazabilidad.domain.model.Traza;
import com.pragma.trazabilidad.domain.spi.ITrazabilidadPersistencePort;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Juan Camilo
 */
@Component
public class TrazaMongoAdapter implements ITrazabilidadPersistencePort {

    private final ITrazabilidadRepository repository;
    private final TrazaMapper mapper;
    private final MongoTemplate mongoTemplate;

    public TrazaMongoAdapter(ITrazabilidadRepository repository,
            TrazaMapper mapper,
            MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mapper = mapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void guardar(Traza traza) {
        repository.save(mapper.toEntity(traza));
    }

    @Override
    public List<Traza> buscarPorIdPedido(Long idPedido) {
        return repository.findByIdPedido(idPedido).stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<EficienciaPedido> calcularEficienciaPedidos() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("estadoNuevo").in("PENDIENTE", "ENTREGADO")),
                Aggregation.group("idPedido")
                        .min("fechaCambio").as("fechaInicio")
                        .max("fechaCambio").as("fechaFin")
                        .first("idEmpleado").as("idEmpleado"),
                Aggregation.project("idEmpleado")
                        .and("_id").as("idPedido")
                        .andExpression("{$dateDiff: {startDate: '$fechaInicio', endDate: '$fechaFin', unit: 'second'}}")
                        .as("duracionSegundos")
        );

        AggregationResults<EficienciaPedido> results
                = mongoTemplate.aggregate(aggregation, "trazabilidad", EficienciaPedido.class);
        return results.getMappedResults();
    }

    @Override
    public List<EficienciaEmpleado> calcularEficienciaEmpleados() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("estadoNuevo").in("PENDIENTE", "ENTREGADO")),
                Aggregation.group("idPedido")
                        .min("fechaCambio").as("fechaInicio")
                        .max("fechaCambio").as("fechaFin")
                        .first("idEmpleado").as("idEmpleado"),
                Aggregation.project("idEmpleado")
                        .andExpression("{$dateDiff: {startDate: '$fechaInicio', endDate: '$fechaFin', unit: 'second'}}")
                        .as("duracion"),
                Aggregation.group("idEmpleado")
                        .avg("duracion").as("promedioSegundos")
                        .count().as("totalPedidos"),
                Aggregation.sort(Sort.Direction.ASC, "promedioSegundos")
        );

        AggregationResults<EficienciaEmpleado> results
                = mongoTemplate.aggregate(aggregation, "trazabilidad", EficienciaEmpleado.class);
        return results.getMappedResults();
    }
}
