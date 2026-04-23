package org.example.mapper;

import org.example.exception.RoomNotEmptyException;
import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RoomNotEmptyMapper implements ExceptionMapper<RoomNotEmptyException> {

    @Override
    public Response toResponse(RoomNotEmptyException ex){
        ErrorMessage error = new ErrorMessage(409,"Conflict" ,ex.getMessage());

        return Response.status(409)
                .entity(error)
                .type("application/json")
                .build();
    }







}
