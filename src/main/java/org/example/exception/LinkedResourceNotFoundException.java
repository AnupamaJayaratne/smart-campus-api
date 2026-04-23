package org.example.exception;

import javax.ws.rs.ext.Provider;


public class LinkedResourceNotFoundException extends RuntimeException{

    public LinkedResourceNotFoundException(
            String message){

        super(message);
    }

}
