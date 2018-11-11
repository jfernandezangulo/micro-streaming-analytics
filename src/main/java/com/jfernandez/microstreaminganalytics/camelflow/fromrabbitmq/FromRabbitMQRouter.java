package com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq;

import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.service.EstadisticasService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase donde se define el flujo de mensajes
 */
@Component
public class FromRabbitMQRouter extends RouteBuilder {

    @Value("${rabbit.uri}")
    private String rabbitUri;

    @Value("${mongo.uri}")
    private String mongoUri;

    @Override
    public void configure() throws Exception {
        from(rabbitUri).log("Mensaje recibido").
                bean(DeviceMessageReceiver.class, "recieveMessage").//Transformo el mensaje a mi modelo
                bean(EstadisticasService.class, "getEstadisticaFromMensaje").//Genero las estadisticas
                to(mongoUri).log("Insertado en mongo").
                setId("flujoHaciaMongo");

    }
}
