package com.tde.apipagabus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tde.apipagabus.domain.response.BaseResponse;
import com.tde.apipagabus.persistence.entity.DescargasPagaBus;
import com.tde.apipagabus.persistence.repository.DescargasPagaBusRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DescargasPagaBusService {

    private final DescargasPagaBusRepository descargasPagaBusRepository;

    @Autowired
    public DescargasPagaBusService(DescargasPagaBusRepository descargasPagaBusRepository) {
        this.descargasPagaBusRepository = descargasPagaBusRepository;
    }

    // Método para buscar por strModem_ID
    public ResponseEntity<BaseResponse<List<DescargasPagaBus>>> findByModemId(String modemId) {
        BaseResponse<List<DescargasPagaBus>> response = new BaseResponse<>();
        try {
            List<DescargasPagaBus> result = descargasPagaBusRepository.findByModemId(modemId);
            if (result.isEmpty()) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("No se encontraron registros para strModem_ID: " + modemId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Registros encontrados");
            //result.forEach(System.out::println);
            response.setData(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error al buscar por strModem_ID: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Método para buscar por rango de fechas
    public ResponseEntity<BaseResponse<List<DescargasPagaBus>>> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        BaseResponse<List<DescargasPagaBus>> response = new BaseResponse<>();
        try {
            List<DescargasPagaBus> result = descargasPagaBusRepository.findByFechaHoraEnvioBetween(startDate, endDate);
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
