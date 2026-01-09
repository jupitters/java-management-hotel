package com.jupitters.JupittersHotel.service;

import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.model.Booking;

public interface BookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);
    Response findBookingByConfirmationCode(String confirmationCode);
    Response getAllBookings();
    Response cancelBooking(Long bookingId);
}
