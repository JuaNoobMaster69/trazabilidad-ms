/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.input.rest.dto;

import java.time.LocalDateTime;

/**
 *
 * @author Juan Camilo
 */
public record TrazaResponseDto(
        String id,
        Long idPedido,
        Long idCliente,
        Long idRestaurante,
        String estadoAnterior,
        String estadoNuevo,
        LocalDateTime fechaCambio,
        Long idEmpleado) {

}
