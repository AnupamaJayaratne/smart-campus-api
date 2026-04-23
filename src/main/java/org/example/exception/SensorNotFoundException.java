package org.example.exception;

import javax.ws.rs.ext.Provider;


public class SensorNotFoundException extends RuntimeException{

    public SensorNotFoundException(String message){
        super(message);
    }


}
