package org.example.service;

import org.example.model.Sensor;

import java.util.Collection;

public interface SensorService {

    Collection<Sensor> getAllSensors();

    Collection<Sensor> getSensorsByType(String type);

    void createSensor(Sensor sensor);

    Sensor getSensorById(String id);



}
