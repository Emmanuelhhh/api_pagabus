package com.tde.apipagabus.domain.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DescargasPagaBusRequest {
    private String strModemId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
