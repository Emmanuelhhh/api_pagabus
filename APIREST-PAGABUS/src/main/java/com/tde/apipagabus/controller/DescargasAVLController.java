package com.tde.apipagabus.controller;

import com.tde.apipagabus.domain.response.BaseResponse;
import com.tde.apipagabus.persistence.entity.DescargasAvl;
import com.tde.apipagabus.service.DescargasAVLService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/descargas-avl")
public class DescargasAVLController {

    private final DescargasAVLService descargasAVLService;

    @Autowired
    public DescargasAVLController(DescargasAVLService descargasAVLService) {
        this.descargasAVLService = descargasAVLService;
    }

    @Operation(summary = "Buscar descargas AVL por modem ID", description = "Devuelve una lista de descargas asociadas a un ID de módem.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registros encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/modem/{modemId}")
    public ResponseEntity<BaseResponse<List<DescargasAvl>>> findByModemId(@PathVariable String modemId) {
        return descargasAVLService.findByModemId(modemId);
    }

    @Operation(summary = "Buscar descargas AVL por rango de fechas", description = "Devuelve una lista de descargas dentro de un rango de fechas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registros encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/fechas")
    public ResponseEntity<BaseResponse<List<DescargasAvl>>> findByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return descargasAVLService.findByDateRange(startDate, endDate);
    }
}
