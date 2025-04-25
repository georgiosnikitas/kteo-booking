package com.example.kteobooking.service;

import com.example.kteobooking.model.Appointment;
import com.example.kteobooking.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
  private final AppointmentRepository repository;

  public AppointmentService(AppointmentRepository repository) {
    this.repository = repository;
  }

  public Appointment createAppointment(Appointment appointment) {
    if (repository.existsByCarPlateAndAppointmentDate(
        appointment.getCarPlate(), appointment.getAppointmentDate())) {
      throw new RuntimeException("Appointment already exists for this car and date.");
    }
    if (!this.isServiceRequired(appointment.getManufacturingYear())) {
      throw new RuntimeException("Service is not required.");
    }
    appointment.setStatus("PENDING");
    return repository.save(appointment);
  }

  public List<Appointment> getAppointments(LocalDate date) {
    LocalDateTime start = date.atStartOfDay();
    LocalDateTime end = date.plusDays(1).atStartOfDay();
    return repository.findByAppointmentDateBetween(start, end);
  }

  public Appointment getAppointment(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
  }

  public boolean isServiceRequired(int manufacturingYear) {
    int currentYear = LocalDate.now().getYear();
    return (currentYear - manufacturingYear) > 3;
  }

}
