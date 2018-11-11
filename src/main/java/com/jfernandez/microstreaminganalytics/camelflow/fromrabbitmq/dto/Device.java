package com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Device implements Serializable {

    private List<Temperature> temperatures;
}
