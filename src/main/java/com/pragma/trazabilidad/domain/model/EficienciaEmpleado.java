/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.domain.model;

/**
 *
 * @author Juan Camilo
 */
public class EficienciaEmpleado {

    private Long idEmpleado;
    private double promedioSegundos;
    private long totalPedidos;

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getPromedioSegundos() {
        return promedioSegundos;
    }

    public void setPromedioSegundos(double promedioSegundos) {
        this.promedioSegundos = promedioSegundos;
    }

    public long getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(long totalPedidos) {
        this.totalPedidos = totalPedidos;
    }
}
