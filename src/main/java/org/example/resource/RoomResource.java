package org.example.resource;

import org.example.model.Room;
import org.example.service.RoomService;
import org.example.service.serviceImpl.RoomServiceImplementation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    private RoomService roomService =
            new RoomServiceImplementation();


    @GET
    public Response getAllRooms(){

        return Response
                .ok(roomService.getAllRooms())
                .build();
    }



    @GET
    @Path("/{id}")
    public Response getRoomById(
            @PathParam("id") String id){

        Room room = roomService.getRoomById(id);

        if(room == null){
            return Response.status(404)
                    .entity("Room not found")
                    .build();
        }

        return Response.ok(room).build();
    }



    @POST
    public Response createRoom(Room room){

        roomService.createRoom(room);

        return Response.status(201)
                .entity(room)
                .build();
    }



    @DELETE
    @Path("/{id}")
    public Response deleteRoom(
            @PathParam("id") String id){

        roomService.deleteRoom(id);

        return Response.noContent().build();
    }
}
