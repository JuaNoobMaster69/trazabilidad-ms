/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.domain.spi;

import com.pragma.trazabilidad.domain.model.EficienciaEmpleado;
import com.pragma.trazabilidad.domain.model.EficienciaPedido;
import com.pragma.trazabilidad.domain.model.Traza;

import java.util.List;

/**
 *
 * @author Juan Camilo
 */
public interface ITrazabilidadPersistencePort {

    void guardar(Traza traza);

    List<Traza> buscarPorIdPedido(Long idPedido);

    List<EficienciaPedido> calcularEficienciaPedidos();

    List<EficienciaEmpleado> calcularEficienciaEmpleados();
}
