/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.input.rest;

import com.pragma.trazabilidad.domain.api.ITrazabilidadServicePort;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.TrazaRequestDto;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.TrazaResponseDto;
import com.pragma.trazabilidad.infrastructure.input.rest.mapper.TrazaRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Juan Camilo
 */
@RestController
@RequestMapping("/trazabilidad")
public class TrazaController {

    private final ITrazabilidadServicePort servicePort;
    private final TrazaRequestMapper mapper;

    public TrazaController(ITrazabilidadServicePort servicePort, TrazaRequestMapper mapper) {
        this.servicePort = servicePort;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> registrarTraza(@RequestBody TrazaRequestDto request) {
        servicePort.registrarTraza(mapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<List<TrazaResponseDto>> obtenerTrazabilidad(@PathVariable Long idPedido) {
        List<TrazaResponseDto> historial = servicePort.obtenerTrazabilidadPorPedido(idPedido)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(historial);
    }
}