package com.jfernandez.microstreaminganalytics.web.dto;

import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.Estadistica;
import lombok.Data;

import java.util.List;

@Data
public class EstadisticasInfo {

    private Long totalEstadisticas;
    private List<Estadistica> estadisticas;
}
