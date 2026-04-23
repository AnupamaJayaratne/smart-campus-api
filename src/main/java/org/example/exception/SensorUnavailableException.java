package org.example.exception;

import javax.ws.rs.ext.Provider;


public class SensorUnavailableException extends RuntimeException{

    public SensorUnavailableException(
            String message){

        super(message);
    }



}
