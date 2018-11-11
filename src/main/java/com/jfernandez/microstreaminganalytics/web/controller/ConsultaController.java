package com.jfernandez.microstreaminganalytics.web.controller;

import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.Estadistica;
import com.jfernandez.microstreaminganalytics.repository.EstadisticaRepository;
import com.jfernandez.microstreaminganalytics.web.dto.EstadisticasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaController {

    @Autowired
    private EstadisticaRepository estadisticaRepository;

    @GetMapping(value = "info")
    public ResponseEntity<EstadisticasInfo> getEstadisticasInfo(){

        Long totalEstadisticas = estadisticaRepository.count();
        List<Estadistica> estadisticas = estadisticaRepository.findAll();

        EstadisticasInfo estadisticasInfo = new EstadisticasInfo();
        estadisticasInfo.setTotalEstadisticas(totalEstadisticas);
        estadisticasInfo.setEstadisticas(estadisticas);

        return ResponseEntity.ok(estadisticasInfo);
    }
}
