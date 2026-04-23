package org.example.service.serviceImpl;

import org.example.exception.RoomNotEmptyException;
import org.example.model.Room;
import org.example.repository.RoomRepository;
import org.example.service.RoomService;

import java.util.Collection;

public class RoomServiceImplementation implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImplementation() {
        this.roomRepository = new RoomRepository();
    }


    @Override
    public Collection<Room> getAllRooms() {
        return roomRepository.findAll();
    }


    @Override
    public Room getRoomById(String id) {
        return roomRepository.findById(id);
    }


    @Override
    public void createRoom(Room room) {

        roomRepository.save(room);
    }


    @Override
    public void deleteRoom(String id) {

        Room room = roomRepository.findById(id);

        if(room == null){
            return;
        }

        if(!room.getSensorIds().isEmpty()){
            throw new RoomNotEmptyException(
                    "Room still has active sensors"
            );
        }

        roomRepository.delete(id);
    }







}
