package com.jfernandez.microstreaminganalytics.repository;

import com.jfernandez.microstreaminganalytics.camelflow.tomongodb.dto.Estadistica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstadisticaRepository extends MongoRepository<Estadistica,String> {
}
