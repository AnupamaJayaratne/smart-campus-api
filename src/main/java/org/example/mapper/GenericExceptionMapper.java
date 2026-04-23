package org.example.mapper;

import org.example.model.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response  toResponse(Exception ex ){

        if(ex instanceof WebApplicationException){
            return ((WebApplicationException) ex)
                    .getResponse();
        }


        ErrorMessage error =  new ErrorMessage(500,"Internal Server Error", ex.getMessage());

        return Response.status(500)
                .entity(error)
                .type("application/json")
                .build();

    }

}
