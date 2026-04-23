package org.example.resource;

import org.example.model.SensorReading;
import org.example.service.SensorReadingService;
import org.example.service.serviceImpl.SensorReadingServiceImplementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SensorReadingResource {

    private String sensorId;

    private SensorReadingService readingService = new SensorReadingServiceImplementation();

    public SensorReadingResource (String sensorId){
        this.sensorId = sensorId;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReadings(){

        return Response.ok(readingService.getReadings(sensorId)).build();
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReading(
            SensorReading reading){

        readingService.addReading(sensorId, reading);

        return Response.status(201)
                .entity(reading)
                .build();
    }



}
