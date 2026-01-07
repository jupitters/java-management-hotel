package com.jupitters.JupittersHotel.utils;

import com.jupitters.JupittersHotel.dto.BookingDto;
import com.jupitters.JupittersHotel.dto.RoomDto;
import com.jupitters.JupittersHotel.dto.UserDto;
import com.jupitters.JupittersHotel.model.Booking;
import com.jupitters.JupittersHotel.model.Room;
import com.jupitters.JupittersHotel.model.User;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateRandomAlphanumeric(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static UserDto mapUserEntityToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public static RoomDto mapRoomEntityToDto(Room room) {
        RoomDto roomDto = new RoomDto();

        roomDto.setId(room.getId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setRoomPrice(room.getRoomPrice());
        roomDto.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDto.setRoomDescription(room.getRoomDescription());
        return roomDto;
    }

    public static BookingDto mapBookingEntityToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(booking.getId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setNumOfAdults(booking.getNumOfAdults());
        bookingDto.setNumOfChildren(booking.getNumOfChildren());
        bookingDto.setTotalNumOfGuests(booking.getTotalNumOfGuests());
        bookingDto.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        return bookingDto;
    }

    public static RoomDto mapRoomEntityToDtoAndBookings(Room room) {
        RoomDto roomDto = new RoomDto();

        roomDto.setId(room.getId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setRoomPrice(room.getRoomPrice());
        roomDto.setRoomPhotoUrl(room.getRoomPhotoUrl());

        if(room.getBookings() != null){
            roomDto.setBookings(room.getBookings()
                    .stream()
                    .map(Utils::mapBookingEntityToDto)
                    .collect(Collectors.toList()));
        }

        return roomDto;
    }

    public static UserDto mapUserEntityToDtoBookingsAndRooms(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRole(user.getRole());

        if(!user.getBookings().isEmpty()) {
            userDto.setBookings(user.getBookings()
                    .stream()
                    .map(booking -> mapBookingEntityToBookingDtoAndBookedRoom(booking, false)).collect(Collectors.toList()));
        }
        return userDto;
    }

    public static BookingDto mapBookingEntityToBookingDtoAndBookedRoom(Booking booking, boolean mapUser){
        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(booking.getId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setNumOfAdults(booking.getNumOfAdults());
        bookingDto.setNumOfChildren(booking.getNumOfChildren());
        bookingDto.setTotalNumOfGuests(booking.getTotalNumOfGuests());
        bookingDto.setBookingConfirmationCode(booking.getBookingConfirmationCode());

        if(mapUser){
            bookingDto.setUser(Utils.mapUserEntityToDto(booking.getUser()));
        }
        if(booking.getRoom() != null){
            RoomDto roomDto = new RoomDto();

            roomDto.setId(booking.getRoom().getId());
            roomDto.setRoomType(booking.getRoom().getRoomType());
            roomDto.setRoomPrice(booking.getRoom().getRoomPrice());
            roomDto.setRoomPhotoUrl(booking.getRoom().getRoomPhotoUrl());
            roomDto.setRoomDescription(booking.getRoom().getRoomDescription());
            bookingDto.setRoom(roomDto);
        }
        return bookingDto;
    }

    public static List<UserDto> mapUserListToDto(List<User> users) {
        return users.stream().map(Utils::mapUserEntityToDto).collect(Collectors.toList());
    }

    public static List<RoomDto> mapRoomListToDto(List<Room> rooms) {
        return rooms.stream().map(Utils::mapRoomEntityToDto).collect(Collectors.toList());
    }

    public static List<BookingDto> mapBookingListToDto(List<Booking> bookings) {
        return bookings.stream().map(Utils::mapBookingEntityToDto).collect(Collectors.toList());
    }

}
