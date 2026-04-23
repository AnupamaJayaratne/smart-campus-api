package org.example.repository;

import org.example.model.Sensor;

import java.util.Collection;

public class SensorRepository {


    public Collection<Sensor> findAll(){
        return DataStore.sensors.values();
    }

    public Sensor findById(String id){
        return DataStore.sensors.get(id);
    }

    public void save(Sensor sensor){
        DataStore.sensors.put(sensor.getId(),sensor);
    }

    public void delete(String id){
        DataStore.sensors.remove(id);
    }


}
