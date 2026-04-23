package org.example.mapper;

import org.example.exception.LinkedResourceNotFoundException;
import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class LinkedResourceMapper implements ExceptionMapper<LinkedResourceNotFoundException> {

    @Override
    public Response toResponse(LinkedResourceNotFoundException ex){

        ErrorMessage error = new ErrorMessage(422,"Unprocessable Entity", ex.getMessage());

        return Response.status(404)
                .entity(error)
                .type("application/json")
                .build();
    }



}
