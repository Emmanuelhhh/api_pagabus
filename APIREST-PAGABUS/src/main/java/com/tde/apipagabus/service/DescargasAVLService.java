package com.tde.apipagabus.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tde.apipagabus.domain.response.BaseResponse;
import com.tde.apipagabus.persistence.entity.DescargasAvl;
import com.tde.apipagabus.persistence.repository.DescargasAvlRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DescargasAVLService {

    private final DescargasAvlRepository DescargasAVLRepository;

    @Autowired
    public DescargasAVLService(DescargasAvlRepository DescargasAVLRepository) {
        this.DescargasAVLRepository = DescargasAVLRepository;
    }

    // Método para buscar por strModemID
    public ResponseEntity<BaseResponse<List<DescargasAvl>>> findByModemId(String modemId) {
        BaseResponse<List<DescargasAvl>> response = new BaseResponse<>();
        try {
            List<DescargasAvl> result = DescargasAVLRepository.findByModemId(modemId);
            if (result.isEmpty()) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("No se encontraron registros para strModemID: " + modemId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Registros encontrados");
            response.setData(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al buscar por strModemID: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Método para buscar por rango de fechas
    public ResponseEntity<BaseResponse<List<DescargasAvl>>> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        BaseResponse<List<DescargasAvl>> response = new BaseResponse<>();
        try {
            List<DescargasAvl> result = DescargasAVLRepository.findByFechaHoraComputadoraBetween(startDate, endDate);
            if (result.isEmpty()) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("No se encontraron registros entre las fechas: " + startDate + " y " + endDate);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Registros encontrados");
            response.setData(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al buscar por rango de fechas: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
