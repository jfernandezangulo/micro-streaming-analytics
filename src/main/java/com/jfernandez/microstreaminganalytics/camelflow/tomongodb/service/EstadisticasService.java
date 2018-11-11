package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.service;

import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.Device;
import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.DeviceMessage;
import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.DateTime;
import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.Estadistica;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class EstadisticasService {

    public Estadistica getEstadisticaFromMensaje(DeviceMessage message){

        Estadistica estadistica = new Estadistica();

        //TODO: REALIZAR LOS CALCULOS ESTADISTICOS
        //Media
        estadistica.setMedia(1D);

        //Mediana
        estadistica.setMediana(1);

        //Moda
        estadistica.setModa(1);

        //desviacionTípica;
        estadistica.setDesviacionTípica(1D);


        //cuartiles;
        //Primer cuartil
        estadistica.setPrimerCuartil(1);

        //Segundo cuartil
        estadistica.setSegundoCuartil(1);

        //Tercer cuartil
        estadistica.setTercerCuartil(1);

        //Maximo
        estadistica.setValorMaximo(1);

        //Minimo
        estadistica.setValorMinimo(1);

        //Incluyo el timestamp
        estadistica.setDateTime(new DateTime(LocalDateTime.now()));

        log.info("Estadistica obtenida: ");
        log.info(estadistica.toString());

        return estadistica;
    }

}
