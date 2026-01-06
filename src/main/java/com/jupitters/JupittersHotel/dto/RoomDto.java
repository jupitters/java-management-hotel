package com.jupitters.JupittersHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jupitters.JupittersHotel.model.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<Booking> bookings;
}
