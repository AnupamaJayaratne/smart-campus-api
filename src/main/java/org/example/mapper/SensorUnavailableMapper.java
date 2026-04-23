package org.example.mapper;

import org.example.exception.SensorUnavailableException;
import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SensorUnavailableMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException ex) {

        System.out.println("SensorUnavailableMapper invoked");
        ErrorMessage error = new ErrorMessage(503,"Forbidden", ex.getMessage());

        return Response.status(503)
                .entity(error)
                .type("application/json")
                .build();
    }
}
