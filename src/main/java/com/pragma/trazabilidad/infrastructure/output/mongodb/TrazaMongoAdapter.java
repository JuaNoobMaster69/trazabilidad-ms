/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.output.mongodb;

import com.pragma.trazabilidad.domain.model.Traza;
import com.pragma.trazabilidad.domain.spi.ITrazabilidadPersistencePort;
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

    public TrazaMongoAdapter(ITrazabilidadRepository repository, TrazaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
}
