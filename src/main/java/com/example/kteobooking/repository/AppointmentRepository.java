package com.example.kteobooking.repository;

import com.example.kteobooking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  boolean existsByCarPlateAndAppointmentDate(String carPlate, LocalDateTime date);
  List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);
}
