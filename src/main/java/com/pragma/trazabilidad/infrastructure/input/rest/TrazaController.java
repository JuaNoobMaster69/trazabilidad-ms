/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pragma.trazabilidad.infrastructure.input.rest;


import com.pragma.trazabilidad.domain.api.ITrazabilidadServicePort;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.EficienciaEmpleadoResponseDto;
import com.pragma.trazabilidad.infrastructure.input.rest.dto.EficienciaPedidoResponseDto;
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

    @GetMapping("/eficiencia/pedidos")
    public ResponseEntity<List<EficienciaPedidoResponseDto>> obtenerEficienciaPedidos() {
        List<EficienciaPedidoResponseDto> resultado = servicePort.obtenerEficienciaPedidos()
                .stream()
                .map(e -> new EficienciaPedidoResponseDto(
                        e.getIdPedido(), e.getIdEmpleado(), e.getDuracionSegundos()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/eficiencia/empleados")
    public ResponseEntity<List<EficienciaEmpleadoResponseDto>> obtenerEficienciaEmpleados() {
        List<EficienciaEmpleadoResponseDto> resultado = servicePort.obtenerEficienciaEmpleados()
                .stream()
                .map(e -> new EficienciaEmpleadoResponseDto(
                        e.getIdEmpleado(), e.getPromedioSegundos(), e.getTotalPedidos()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }
}