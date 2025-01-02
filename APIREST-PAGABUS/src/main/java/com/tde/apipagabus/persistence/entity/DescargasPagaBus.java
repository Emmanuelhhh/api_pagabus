package com.tde.apipagabus.persistence.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
@Table(name = "tbldescargaspagabus")
public class DescargasPagaBus implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_dgprs", nullable = false)
    private Long idDgprs;

    @Column(name = "dtotalefectivoregistrado")
    private Double totalEfectivoRegistrado;

    @Column(name = "dtotalventas")
    private Double totalVentas;

    @Column(name = "dtotalventastarifa0")
    private Double totalVentasTarifa0;

    @Column(name = "dtotalventastarifa1")
    private Double totalVentasTarifa1;

    @Column(name = "dtotalventastarifa2")
    private Double totalVentasTarifa2;

    @Column(name = "dtotalventastarifa3")
    private Double totalVentasTarifa3;

    @Column(name = "dtotalventastarifa4")
    private Double totalVentasTarifa4;

    @Column(name = "dtotalventastarifa5")
    private Double totalVentasTarifa5;

    @Column(name = "dtotalventastarifa6")
    private Double totalVentasTarifa6;

    @Column(name = "dtotalventastarifa7")
    private Double totalVentasTarifa7;

    @Column(name = "dtotalventastarifa8")
    private Double totalVentasTarifa8;

    @Column(name = "dtotalventastarifa9")
    private Double totalVentasTarifa9;

    @Column(name = "dfehahoraenvio")
    private LocalDateTime fechaHoraEnvio;

    @Column(name = "strmodem_id")
    private String modemId;

    @Column(name = "dfehahorainsert")
    private LocalDateTime fechaHoraInsert;

    @Column(name = "intcontadorciclico")
    private Integer contadorCiclico;
}
