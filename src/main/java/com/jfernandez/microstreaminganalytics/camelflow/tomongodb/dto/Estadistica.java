package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto;

import lombok.Data;


@Data
public class Estadistica {


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
