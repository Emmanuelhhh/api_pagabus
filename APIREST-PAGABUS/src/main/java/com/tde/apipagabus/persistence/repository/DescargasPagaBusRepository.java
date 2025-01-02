package com.tde.apipagabus.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tde.apipagabus.persistence.entity.DescargasPagaBus;

@Repository
public interface DescargasPagaBusRepository extends JpaRepository<DescargasPagaBus, Long> {

    // Método de búsqueda por 'strModem_ID'
    List<DescargasPagaBus> findByModemId(String strModemId);

    // Método de búsqueda por rango de fechas (dFehaHoraEnvio)
    List<DescargasPagaBus> findByFechaHoraEnvioBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}