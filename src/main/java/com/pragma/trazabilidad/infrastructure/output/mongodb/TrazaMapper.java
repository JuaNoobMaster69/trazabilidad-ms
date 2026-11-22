/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.output.mongodb;

import com.pragma.trazabilidad.domain.model.Traza;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Camilo
 */
@Component
public class TrazaMapper {

    public TrazaEntity toEntity(Traza traza) {
        TrazaEntity entity = new TrazaEntity();
        entity.setId(traza.getId());
        entity.setIdPedido(traza.getIdPedido());
        entity.setIdCliente(traza.getIdCliente());
        entity.setIdRestaurante(traza.getIdRestaurante());
        entity.setEstadoAnterior(traza.getEstadoAnterior());
        entity.setEstadoNuevo(traza.getEstadoNuevo());
        entity.setFechaCambio(traza.getFechaCambio());
        entity.setIdEmpleado(traza.getIdEmpleado());
        return entity;
    }

    public Traza toModel(TrazaEntity entity) {
        Traza traza = new Traza();
        traza.setId(entity.getId());
        traza.setIdPedido(entity.getIdPedido());
        traza.setIdCliente(entity.getIdCliente());
        traza.setIdRestaurante(entity.getIdRestaurante());
        traza.setEstadoAnterior(entity.getEstadoAnterior());
        traza.setEstadoNuevo(entity.getEstadoNuevo());
        traza.setFechaCambio(entity.getFechaCambio());
        traza.setIdEmpleado(entity.getIdEmpleado());
        return traza;
    }
}
