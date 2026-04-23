package org.example.exception;

import javax.ws.rs.ext.Provider;


public class RoomNotEmptyException extends RuntimeException {

    public RoomNotEmptyException(String message){
        super(message);

    }


}
