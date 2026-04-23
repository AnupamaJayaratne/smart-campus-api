package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args)
            throws IOException {

        String BASE_URI = "http://localhost:8080/api/v1";


        ResourceConfig config =
                new ResourceConfig().register(org.example.resource.DiscoveryResource.class)
                        .register(org.example.resource.RoomResource.class)
                        .register(org.example.resource.SensorResource.class)
                        .register(org.example.mapper.RoomNotEmptyMapper.class)
                        .register(org.example.mapper.LinkedResourceMapper.class)
                        .register(org.example.mapper.SensorUnavailableMapper.class)
                        .register(org.example.mapper.SensorNotFoundExceptionMapper.class)
                        .register(org.example.mapper.GenericExceptionMapper.class)
                        .register(org.example.filter.LoggingFilter.class);


        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);


        System.out.println("Server running at " + BASE_URI + "api/v1");

        System.in.read();

        server.shutdownNow();

    }


}