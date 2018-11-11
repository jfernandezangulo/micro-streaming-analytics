package com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.DeviceMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Slf4j
public class DeviceMessageReceiver {

    private ObjectMapper objectMapper;

    @PostConstruct
    private void init(){
        objectMapper = new ObjectMapper();
    }

    public DeviceMessage recieveMessage(String message) throws IOException {

        log.info("Este es el mensaje: " + message);

        return objectMapper.readValue(message,DeviceMessage.class);
    }

    public void recieveMongoMessage(String message){
        log.info("Este es el mensaje mongo: " + message);
    }
}
