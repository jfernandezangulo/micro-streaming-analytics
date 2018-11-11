package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto;


import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document
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
