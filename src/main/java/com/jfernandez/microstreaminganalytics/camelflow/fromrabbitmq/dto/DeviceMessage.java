package com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceMessage implements Serializable {

    private Device device;
}
