package com.tde.apipagabus.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tblDescargasAVL")
public class DescargasAvl implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "intTipoAVL")
    private Integer tipoAvl;

    @Column(name = "strModemID")
    private String modemId;

    @Column(name = "fLongitud_grad")
    private Double longitud;

    @Column(name = "fLatitud_grad")
    private Double latitud;

    @Column(name = "intVelocidad")
    private Integer velocidad;

    @Column(name = "intAltitud")
    private Integer altitud;

    @Column(name = "intNum_Sat")
    private Integer numSat;

    @Column(name = "intHeading")
    private Integer heading;

    @Column(name = "dFecha_Hora_SAT")
    private LocalDateTime fechaHoraSat;

    @Column(name = "intTipo_Evento")
    private Integer tipoEvento;

    @Column(name = "intVariable1")
    private Integer variable1;

    @Column(name = "intVariable2")
    private Integer variable2;

    @Column(name = "intVariable3")
    private Integer variable3;

    @Column(name = "intVariable4")
    private Integer variable4;

    @Column(name = "dFechaHoraComputadora")
    private LocalDateTime fechaHoraComputadora;

    @Column(name = "intVarControl")
    private Integer varControl;

    @Column(name = "intId_Asignacion")
    private Long idAsignacion;

    @Column(name = "intStatus")
    private Integer status;
}
