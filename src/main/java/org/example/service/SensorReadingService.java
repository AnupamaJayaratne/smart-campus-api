package org.example.service;

import org.example.model.SensorReading;

import java.util.List;

public interface SensorReadingService {
    List<SensorReading> getReadings(String sensorId);

    void addReading(String sensorId, SensorReading reading);

}
