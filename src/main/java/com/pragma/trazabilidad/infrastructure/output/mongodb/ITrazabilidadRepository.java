/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.output.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 *
 * @author Juan Camilo
 */
public interface ITrazabilidadRepository extends MongoRepository<TrazaEntity, String> {

    List<TrazaEntity> findByIdPedido(Long idPedido);
}
