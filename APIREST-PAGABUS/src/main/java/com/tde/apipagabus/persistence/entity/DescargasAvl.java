package com.tde.apipagabus.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbldescargasavl")
public class DescargasAvl implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "inttipoavl")
    private Integer tipoAvl;

    @Column(name = "strmodemid")
    private String modemId;

    @Column(name = "flongitud_grad")
    private Double longitud;

    @Column(name = "flatitud_grad")
    private Double latitud;

    @Column(name = "intvelocidad")
    private Integer velocidad;

    @Column(name = "intaltitud")
    private Integer altitud;

    @Column(name = "intnum_sat")
    private Integer numSat;

    @Column(name = "intheading")
    private Integer heading;

    @Column(name = "dfecha_hora_sat")
    private LocalDateTime fechaHoraSat;

    @Column(name = "inttipo_evento")
    private Integer tipoEvento;

    @Column(name = "intvariable1")
    private Integer variable1;

    @Column(name = "intvariable2")
    private Integer variable2;

    @Column(name = "intvariable3")
    private Integer variable3;

    @Column(name = "intvariable4")
    private Integer variable4;

    @Column(name = "dfechahoracomputadora")
    private LocalDateTime fechaHoraComputadora;

    @Column(name = "intvarcontrol")
    private Integer varControl;

    @Column(name = "intid_asignacion")
    private Long idAsignacion;

    @Column(name = "intstatus")
    private Integer status;
}
