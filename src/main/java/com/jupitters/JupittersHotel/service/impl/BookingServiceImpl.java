package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.model.Booking;
import com.jupitters.JupittersHotel.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public Response saveBooking(Long roomId, Long userId, Booking bookingRequest) {
        return null;
    }

    @Override
    public Response findBookingByConfirmationCode(String confirmationCode) {
        return null;
    }

    @Override
    public Response getAllBookings() {
        return null;
    }

    @Override
    public Response cancelBooking(Long bookingId) {
        return null;
    }
}
