package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "estadisticas")
public class Estadistica {

    @Id
    private String id;

    private DateTime dateTime;

    private Double media;

    private Integer mediana;

    private Integer moda;

    private Double desviacionTípica;

    private Integer primerCuartil;

    private Integer segundoCuartil;

    private Integer tercerCuartil;

    private Integer valorMaximo;

    private Integer valorMinimo;

}
