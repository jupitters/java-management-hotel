package com.jupitters.JupittersHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jupitters.JupittersHotel.model.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<Booking> bookings = new ArrayList<>();
}
