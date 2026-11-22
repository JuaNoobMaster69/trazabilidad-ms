/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.application.usecase;

import com.pragma.trazabilidad.domain.api.ITrazabilidadServicePort;
import com.pragma.trazabilidad.domain.model.Traza;
import com.pragma.trazabilidad.domain.spi.ITrazabilidadPersistencePort;
import java.util.List;
/**
 *
 * @author Juan Camilo
 */
public class TrazabilidadUseCase implements ITrazabilidadServicePort {

    private final ITrazabilidadPersistencePort persistencePort;

    public TrazabilidadUseCase(ITrazabilidadPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void registrarTraza(Traza traza) {
        persistencePort.guardar(traza);
    }

    @Override
    public List<Traza> obtenerTrazabilidadPorPedido(Long idPedido) {
        return persistencePort.buscarPorIdPedido(idPedido);
    }
}