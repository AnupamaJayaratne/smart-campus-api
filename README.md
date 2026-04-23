# Smart Campus Monitoring REST API

## Overview

This project implements a RESTful Smart Campus Monitoring API using Java, JAX-RS (Jersey), and an embedded Grizzly server.

The API supports management of:

- Rooms
- Sensors
- Sensor Readings

### API Design

The system follows REST principles using:

- Resource-oriented endpoints

```text
/api/v1/rooms
/api/v1/sensors
/api/v1/sensors/{sensorId}/readings
```

- Query parameter filtering:

```text
GET /api/v1/sensors?type=Temperature
```

- Sub-resource locator design for sensor readings.

### Business Rules

The API enforces:

- Rooms with active sensors cannot be deleted
- Sensors must belong to an existing room
- Sensors in MAINTENANCE mode reject readings

### Technologies Used

- Java 17
- JAX-RS (Jersey)
- Embedded Grizzly HTTP Server
- Maven
- Postman / curl


---

# Build and Run Instructions

## Clone Repository

```bash
git clone https://github.com/AnupamaJayaratne/smart-campus-api.git
cd smart-campus-api
```

---

## Build Project

```bash
mvn clean install
```

---

## Run Server

Run:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Or run `Main.java` from IntelliJ.

Server starts at:

```text
http://localhost:8080/api/v1
```

---

# Sample curl Commands

## 1 Create a Room

```bash
curl -X POST http://localhost:8080/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{
"id":"LIB-301",
"name":"Quiet Study Room",
"capacity":50
}'
```

---

## 2 Get All Rooms

```bash
curl http://localhost:8080/api/v1/rooms
```

---

## 3 Register Sensor

```bash
curl -X POST http://localhost:8080/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{
"id":"TEMP-01",
"type":"Temperature",
"status":"ACTIVE",
"currentValue":22.5,
"roomId":"LIB-301"
}'
```

---

## 4 Add Sensor Reading

```bash
curl -X POST http://localhost:8080/api/v1/sensors/TEMP-01/readings \
-H "Content-Type: application/json" \
-d '{
"id":"r1",
"timestamp":1713200000,
"value":23.7
}'
```

---

## 5 Filter Sensors by Type

```bash
curl http://localhost:8080/api/v1/sensors?type=Temperature
```

---

## 6 Demonstrate Business Rule Violation

```bash
curl -X DELETE http://localhost:8080/api/v1/rooms/LIB-301
```

Expected response:

```text
409 Conflict
```

---

# Project Structure

```text
src/main/java

config/
resource/
service/
repository/
exception/
mapper/
filter/
model/
```
