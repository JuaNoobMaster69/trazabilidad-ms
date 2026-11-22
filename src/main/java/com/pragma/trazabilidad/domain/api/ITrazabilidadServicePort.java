/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pragma.trazabilidad.domain.api;

import com.pragma.trazabilidad.domain.model.Traza;
import java.util.List;
/**
 *
 * @author Juan Camilo
 */
public interface ITrazabilidadServicePort {
    void registrarTraza(Traza traza);
    List<Traza> obtenerTrazabilidadPorPedido(Long idPedido);
}