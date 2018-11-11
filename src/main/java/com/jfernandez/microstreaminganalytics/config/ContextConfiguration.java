package com.jfernandez.microstreaminganalytics.config;

import com.jfernandez.microstreaminganalytics.repository.EstadisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ContextConfiguration {

    @Autowired
    private EstadisticaRepository estadisticaRepository;

    @PostConstruct
    private void init(){
        estadisticaRepository.deleteAll();
    }
}
