package com.jupitters.JupittersHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private String bookings;
}
