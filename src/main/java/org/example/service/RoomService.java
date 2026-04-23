package org.example.service;

import org.example.model.Room;

import java.util.Collection;

public interface RoomService {
    Collection<Room> getAllRooms();

    Room getRoomById(String id);

    void createRoom(Room room);

    void deleteRoom(String id);

}
