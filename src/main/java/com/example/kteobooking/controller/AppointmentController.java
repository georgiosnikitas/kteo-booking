package com.example.kteobooking.controller;

import com.example.kteobooking.model.Appointment;
import com.example.kteobooking.service.AppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
  private final AppointmentService service;

  public AppointmentController(AppointmentService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
    return ResponseEntity.ok(service.createAppointment(appointment));
  }

  @GetMapping
  public List<Appointment> getByDate(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    return service.getAppointments(date);
  }

  @GetMapping("/{id}")
  public Appointment getById(@PathVariable Long id) {
    return service.getAppointment(id);
  }
}
