package com.tde.apipagabus.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tde.apipagabus.persistence.entity.DescargasAvl;

@Repository
public interface DescargasAvlRepository extends JpaRepository<DescargasAvl, Long> {
	// Buscar por strModemID
    List<DescargasAvl> findByModemId(String modemId);

    // Buscar por rango de fechas en dFechaHoraComputadora
    List<DescargasAvl> findByFechaHoraComputadoraBetween(LocalDateTime startDate, LocalDateTime endDate);

}