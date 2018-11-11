package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    private String value;


    public DateTime(){}


    public DateTime(LocalDateTime value){
        this.value = dateFormat.format(value);
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
