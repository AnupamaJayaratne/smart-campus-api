package org.example.service.serviceImpl;

import org.example.exception.LinkedResourceNotFoundException;
import org.example.model.Room;
import org.example.model.Sensor;
import org.example.repository.RoomRepository;
import org.example.repository.SensorRepository;
import org.example.service.SensorService;

import java.util.Collection;
import java.util.stream.Collectors;

public class SensorServiceImplementation implements SensorService {

    private final SensorRepository sensorRepo;
    private final RoomRepository roomRepo;

    public SensorServiceImplementation() {
        this.sensorRepo = new SensorRepository();
        this.roomRepo = new RoomRepository();
    }

    @Override
    public Collection<Sensor> getAllSensors(){
        return sensorRepo.findAll();
    }



    @Override
    public Collection<Sensor> getSensorsByType(
            String type){

        return sensorRepo.findAll()
                .stream()
                .filter(s ->
                        s.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }



    @Override
    public Sensor getSensorById(String id){
        return sensorRepo.findById(id);
    }



    @Override
    public void createSensor(Sensor sensor){

        Room room = roomRepo.findById(sensor.getRoomId());

        if(room==null){
            throw new LinkedResourceNotFoundException(
                    "Referenced room not found"
            );
        }

        sensorRepo.save(sensor);

        room.addSensor(sensor.getId());

    }




}
