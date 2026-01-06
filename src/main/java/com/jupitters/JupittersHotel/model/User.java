package com.jupitters.JupittersHotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private String role;
    private List<Booking> bookings = new ArrayList<>();
}
