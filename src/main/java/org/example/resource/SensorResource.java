package org.example.resource;

import org.example.model.Sensor;
import org.example.service.SensorService;
import org.example.service.serviceImpl.SensorServiceImplementation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {
    private SensorService sensorService = new SensorServiceImplementation();


    @GET
    public Response getSensors(@QueryParam("type") String type){
        if(type != null){
            return Response.ok(sensorService.getSensorsByType(type)).
                    build();
        }

        return Response.ok(sensorService.getAllSensors())
                .build();

    }



    @POST
    public Response createSensor(Sensor sensor){

        sensorService.createSensor(sensor);

        return Response.status(201)
                .entity(sensor)
                .build();

    }

    @Path("/{sensorId}/readings")
    public SensorReadingResource getReadingResource(
            @PathParam("sensorId") String sensorId){

        return new SensorReadingResource(sensorId);
    }




}
