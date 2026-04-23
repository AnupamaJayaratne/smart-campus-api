package org.example.mapper;

import org.example.exception.SensorNotFoundException;
import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SensorNotFoundExceptionMapper implements ExceptionMapper<SensorNotFoundException> {

    @Override
    public Response toResponse(SensorNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(404,"Not Found", ex.getMessage());

        return Response.status(404)
                .entity(error)
                .type("application/json")
                .build();
    }
}
