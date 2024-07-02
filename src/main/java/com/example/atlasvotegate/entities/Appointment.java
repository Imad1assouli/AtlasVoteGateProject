package com.example.atlasvotegate.entities;

import com.example.atlasvotegate.enumurations.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CNI is mandatory")
    @Column(name = "cni", nullable = false, unique = true)
    private String cni;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should have at least 6 characters")
    @Column(name = "password", nullable = false)
    private String password; // Storing hashed version for security.

    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status;

    @Column(name = "nom")
    @NotBlank(message = "Nom is mandatory")
    private String nom;

    @Column(name = "prenom")
    @NotBlank(message = "Prenom is mandatory")
    private String prenom;

}
