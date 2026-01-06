package com.jupitters.JupittersHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jupitters.JupittersHotel.model.Room;
import com.jupitters.JupittersHotel.model.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuests;
    private String bookingConfirmationCode;
    private UserDto user;
    private RoomDto room;
}
