# ΚΤΕΟ Booking API

A simple Spring Boot REST API for booking car inspection (ΚΤΕΟ) appointments.

## Endpoints

- POST `/api/appointments` - Create an appointment
- GET `/api/appointments?date=YYYY-MM-DD` - List appointments by date
- GET `/api/appointments/{id}` - Get appointment by id

## H2 Console

Visit [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
JDBC URL: `jdbc:h2:mem:kteo_db`

