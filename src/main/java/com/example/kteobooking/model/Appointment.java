package com.example.kteobooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ownerName;
  private String carPlate;
  private String carModel;
  private int manufacturingYear;
  private LocalDateTime appointmentDate;
  private String status; // e.g., PENDING, CONFIRMED

  // Getters and Setters

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getOwnerName() { return ownerName; }
  public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

  public String getCarPlate() { return carPlate; }
  public void setCarPlate(String carPlate) { this.carPlate = carPlate; }

  public String getCarModel() { return carModel; }
  public void setCarModel(String carModel) { this.carModel = carModel; }

  public int getManufacturingYear() { return manufacturingYear; }
  public void setManufacturingYear(int manufacturingYear) { this.manufacturingYear = manufacturingYear; }

  public LocalDateTime getAppointmentDate() { return appointmentDate; }
  public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
