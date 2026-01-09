package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.exception.ResourceNotFoundException;
import com.jupitters.JupittersHotel.model.Booking;
import com.jupitters.JupittersHotel.model.Room;
import com.jupitters.JupittersHotel.model.User;
import com.jupitters.JupittersHotel.repo.BookingRepository;
import com.jupitters.JupittersHotel.repo.RoomRepository;
import com.jupitters.JupittersHotel.repo.UserRepository;
import com.jupitters.JupittersHotel.service.BookingService;
import com.jupitters.JupittersHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomService roomService;

    @Override
    public Response saveBooking(Long roomId, Long userId, Booking bookingRequest) {
        Response response = new Response();
        try{
            if(bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())){
                throw new IllegalArgumentException("CheckIn must come before checkOutDate");
            }
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

            List<Booking> existingBookings = room.getBookings();
            if(!roomIsAvailable(bookingRequest, existingBookings)){
                throw new RuntimeException("Room is not available");
            }
            
        }catch (Exception e){

        }

        return response;
    }

    private boolean roomIsAvailable(Booking bookingRequest, List<Booking> existingBookings) {
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
