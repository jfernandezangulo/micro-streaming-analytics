package com.jfernandez.microstreaminganalytics.camelflow.torabbitmq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase donde se define el envio de mensajes simulando a rabbitmq
 */
@Component
public class ToRabbitMQRouter extends RouteBuilder {

    @Value("${rabbit.uri}")
    private String rabbitUri;

    @Override
    public void configure() throws Exception {

        from("timer:messagesTimer?fixedRate=true&period=2000").log("Enviando mensaje").
                bean(MessageBuilder.class,"getMessage").
                to(rabbitUri).
                setId("flujoHaciaRabbit");
    }
}
