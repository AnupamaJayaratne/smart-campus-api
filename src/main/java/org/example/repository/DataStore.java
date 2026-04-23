package org.example.repository;

import org.example.model.Room;
import org.example.model.Sensor;
import org.example.model.SensorReading;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataStore {

    public static final Map<String , Room> rooms = new ConcurrentHashMap<>();

    public static final Map<String, Sensor> sensors = new ConcurrentHashMap<>();

    public static final Map<String , List<SensorReading>> readings = new ConcurrentHashMap<>();



}
