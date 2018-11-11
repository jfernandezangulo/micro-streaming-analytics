package com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Temperature implements Serializable {

    private Integer value;
}
