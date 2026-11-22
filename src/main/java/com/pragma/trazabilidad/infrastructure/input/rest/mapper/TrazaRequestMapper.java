/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.input.rest.mapper;

import com.pragma.trazabilidad.domain.model.Traza;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.TrazaRequestDto;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.TrazaResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
/**
 *
 * @author Juan Camilo
 */
@Component
public class TrazaRequestMapper {

    public Traza toModel(TrazaRequestDto dto) {
        Traza traza = new Traza();
        traza.setIdPedido(dto.idPedido());
        traza.setIdCliente(dto.idCliente());
        traza.setIdRestaurante(dto.idRestaurante());
        traza.setEstadoAnterior(dto.estadoAnterior());
        traza.setEstadoNuevo(dto.estadoNuevo());
        traza.setFechaCambio(LocalDateTime.now()); // La fecha se genera al momento del registro
        traza.setIdEmpleado(dto.idEmpleado());
        return traza;
    }

    public TrazaResponseDto toResponse(Traza traza) {
        return new TrazaResponseDto(
                traza.getId(),
                traza.getIdPedido(),
                traza.getIdCliente(),
                traza.getIdRestaurante(),
                traza.getEstadoAnterior(),
                traza.getEstadoNuevo(),
                traza.getFechaCambio(),
                traza.getIdEmpleado()
        );
    }
}