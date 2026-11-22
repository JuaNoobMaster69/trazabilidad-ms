/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.config;

import com.pragma.trazabilidad.application.usecase.TrazabilidadUseCase;
import com.pragma.trazabilidad.domain.api.ITrazabilidadServicePort;
import com.pragma.trazabilidad.domain.spi.ITrazabilidadPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Juan Camilo
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ITrazabilidadServicePort trazabilidadServicePort(ITrazabilidadPersistencePort persistencePort) {
        return new TrazabilidadUseCase(persistencePort);
    }
}
