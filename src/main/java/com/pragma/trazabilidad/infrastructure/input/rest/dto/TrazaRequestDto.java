/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.input.rest.dto;

/**
 *
 * @author Juan Camilo
 */
public record TrazaRequestDto(
        Long idPedido,
        Long idCliente,
        Long idRestaurante,
        String estadoAnterior,
        String estadoNuevo,
        Long idEmpleado) {
}
