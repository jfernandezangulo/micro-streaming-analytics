package com.jfernandez.microstreaminganalytics.camelflow.torabbitmq;

import org.springframework.stereotype.Component;


@Component
public class MessageBuilder {


    private static final String MENSAJE_UNO = "{\"device\": {\"temperatures\": [{\"value\": \"40\"},{\"value\": \"20\"},{\"value\": \"70\"},{\"value\": \"50\"},{\"value\": \"20\"}]}}";
    private static final String MENSAJE_DOS = "{\"device\": {\"temperatures\": [{\"value\": \"10\"},{\"value\": \"90\"},{\"value\": \"30\"},{\"value\": \"70\"},{\"value\": \"70\"}]}}";
    private static final String MENSAJE_TRES = "{\"device\": {\"temperatures\": [{\"value\": \"90\"},{\"value\": \"20\"},{\"value\": \"40\"},{\"value\": \"30\"},{\"value\": \"30\"}]}}";


    public String getMessage() {

        int indice = (int) (Math.random() * 3) + 1;

        String mensaje = null;

        if(indice == 1){
            mensaje = MENSAJE_UNO;
        } else if(indice == 2){
            mensaje = MENSAJE_DOS;
        } else{
            mensaje = MENSAJE_TRES;
        }

        return mensaje;
    }
}
