package org.example.repository;

import org.example.model.Room;

import java.util.Collection;

public class RoomRepository {

    public Collection<Room> findAll(){
        return DataStore.rooms.values();
    }

    public Room findById(String id){
        return DataStore.rooms.get(id);
    }

    public void save(Room room){
        DataStore.rooms.put(room.getId(),room);
    }

    public void delete(String id){
        DataStore.rooms.remove(id);
    }


}
