package org.example.service.serviceImpl;

import org.example.exception.SensorNotFoundException;
import org.example.exception.SensorUnavailableException;
import org.example.model.Sensor;
import org.example.model.SensorReading;
import org.example.model.enums.SensorStatus;
import org.example.repository.DataStore;
import org.example.repository.SensorRepository;
import org.example.service.SensorReadingService;

import java.util.ArrayList;
import java.util.List;

public class SensorReadingServiceImplementation implements SensorReadingService {

    private  SensorRepository sensorRepo = new SensorRepository();



    @Override
    public List<SensorReading> getReadings(String sensorId){
        return DataStore.readings.getOrDefault(sensorId,new ArrayList<>());
    }



    @Override
    public void addReading(String sensorId, SensorReading reading){

        Sensor sensor=sensorRepo.findById(sensorId);
        System.out.println(sensorId);
        System.out.println(sensor);

        if(sensor==null){
            throw new SensorNotFoundException("Sensor not found");
        }


        if(sensor.getStatus() == SensorStatus.MAINTENANCE){
            throw new SensorUnavailableException("Sensor unavailable");
        }

        DataStore.readings.computeIfAbsent(sensorId, k-> new ArrayList<>())
                .add(reading);

        sensor.setCurrentValue(reading.getValue());
    }

}
