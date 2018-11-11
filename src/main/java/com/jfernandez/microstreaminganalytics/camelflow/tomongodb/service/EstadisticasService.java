package com.jfernandez.microstreaminganalytics.camelflow.tomongodb.service;

import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.Device;
import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.DeviceMessage;
import com.jfernandez.microstreaminganalytics.camelflow.fromrabbitmq.dto.Temperature;
import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.DateTime;
import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.Estadistica;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class EstadisticasService {

    public Estadistica getEstadisticaFromMensaje(DeviceMessage message){

        Estadistica estadistica = new Estadistica();

        Device device = message.getDevice();

        int suma = 0;
        int numeroElementos = device.getTemperatures().size();

        int temperatureValue;

        int max = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;

        Map<Integer,Integer> frecuencias = new HashMap<>();
        int frecuencia;

        //Ordeno el array de menor a mayor para calcular la mediana
        List<Temperature> temperatures = device.getTemperatures();
        temperatures.sort((t1,t2) -> t1.getValue().compareTo(t2.getValue()));

        for(Temperature temperature : device.getTemperatures()){
            temperatureValue = temperature.getValue();

            //Para calcular la media
            suma = suma + temperatureValue;

            //Maximo
            if(temperatureValue > max){
                max = temperatureValue;
            }

            //Minimo
            if(temperatureValue < min){
                min = temperatureValue;
            }

            //Para calcular la moda
            frecuencia = Optional.ofNullable(frecuencias.get(temperatureValue)).orElse(0);
            frecuencias.put(temperatureValue, frecuencia + 1);
        }

        //Media
        estadistica.setMedia(Double.valueOf(suma / numeroElementos));

        //Mediana
        int mediana;
        int indice;
        if(numeroElementos % 2 == 0){
            indice = (numeroElementos / 2) - 1;
            mediana = (temperatures.get(indice).getValue() + temperatures.get(indice + 1).getValue()) / 2;
        } else{
            indice = (int)(numeroElementos / 2);
            mediana = temperatures.get(indice).getValue();
        }
        estadistica.setMediana(mediana);

        //Moda
        int moda = frecuencias.keySet().stream().max(
                (f1,f2) -> frecuencias.get(f1).compareTo(frecuencias.get(f2))).get();
        estadistica.setModa(moda);

        //desviacionTípica;
        double rango;
        double varianza = 0;

        for (Temperature temperature : temperatures) {

            rango = Math.pow(temperature.getValue() - estadistica.getMedia(), 2f);
            varianza = varianza + rango;
        }

        varianza = varianza / 10f;

        double desviacion = Math.sqrt(varianza);
        estadistica.setDesviacionTípica(desviacion);


        //cuartiles;
        //Primer cuartil
        int indiceCuartil = ((numeroElementos + 1) / 4) - 1;
        estadistica.setPrimerCuartil(temperatures.get(indiceCuartil).getValue());

        //Segundo cuartil
        estadistica.setSegundoCuartil(mediana);

        //Tercer cuartil
        indiceCuartil = ((3 * (numeroElementos + 1)) / 4) - 1;
        estadistica.setTercerCuartil(temperatures.get(indiceCuartil).getValue());

        //Maximo
        estadistica.setValorMaximo(max);

        //Minimo
        estadistica.setValorMinimo(min);

        //Incluyo el timestamp
        estadistica.setDateTime(new DateTime(LocalDateTime.now()));

        log.info("Estadistica obtenida: ");
        log.info(estadistica.toString());

        return estadistica;
    }

}
