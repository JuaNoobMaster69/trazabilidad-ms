/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.domain.model;

/**
 *
 * @author Juan Camilo
 */
public class EficienciaPedido {

    private Long idPedido;
    private Long idEmpleado;
    private long duracionSegundos;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public long getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(long duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }
}
