package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.dto.RoomDto;
import com.jupitters.JupittersHotel.exception.ResourceNotFoundException;
import com.jupitters.JupittersHotel.model.Room;
import com.jupitters.JupittersHotel.repo.BookingRepository;
import com.jupitters.JupittersHotel.repo.RoomRepository;
import com.jupitters.JupittersHotel.service.RoomService;
import com.jupitters.JupittersHotel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

//    @Autowired
//    private AwsS3Service awsS3Service;

    @Override
    public Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description) {
        Response response = new Response();
        try{
            // String imageUrl = awsS3Service.saveImageToS3(photo);
            Room room = new Room();
//            room.setRoomPhotoUrl(imageUrl);
            room.setRoomType(roomType);
            room.setRoomPrice(roomPrice);
            room.setRoomDescription(description);
            Room savedRoom = roomRepository.save(room);
            RoomDto roomDto = Utils.mapRoomEntityToDto(savedRoom);
            response.setStatusCode(201);
            response.setRoom(roomDto);
        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public List<String> getAllRoomTypes() {
            return roomRepository.findDistinctRoomTypes();
    }

    @Override
    public Response getAllRooms() {
        Response response = new Response();

        try{
            List<Room> rooms = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            List<RoomDto> roomsDto = Utils.mapRoomListToDto(rooms);
            response.setStatusCode(200);
            response.setRoomList(roomsDto);
        }catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response deleteRoom(Long roomId) {
        Response response = new Response();

        try{
            roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
            roomRepository.deleteById(roomId);
            response.setStatusCode(200);
            response.setMessage("Deleted Successfully!");
        }catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response updateRoom(Long roomId, String description, String roomType, BigDecimal roomPrice, MultipartFile photo) {
        Response response = new Response();

        try{
            String imageUrl = null;
//            if(photo != null && !photo.isEmpty()){
//                imageUrl = awsS3Service.saveImageToS3(photo);
//            }
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
            if(roomType != null) room.setRoomType(roomType);
            if(roomPrice != null) room.setRoomPrice(roomPrice);
            if(description != null) room.setRoomDescription(description);
            if(imageUrl != null) room.setRoomPhotoUrl(imageUrl);

            Room updatedRoom = roomRepository.save(room);
            RoomDto roomDto = Utils.mapRoomEntityToDto(updatedRoom);

            response.setStatusCode(200);
            response.setMessage("Deleted Successfully!");
            response.setRoom(roomDto);
        }catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getRoomById(Long roomId) {
        Response response = new Response();

        try{
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found");
            RoomDto roomDto = Utils.mapRoomEntityToDtoAndBookings(room);

            response.setStatusCode(200);
            response.setMessage("Deleted Successfully!");
            response.setRoom(roomDto);
        }catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        Response response = new Response();

        try{
            List<Room> roomsAvailable = roomRepository.findAvailableRoomsByDatesAndTypes(checkInDate, checkOutDate, roomType);
            List<RoomDto> roomsDto = Utils.mapRoomListToDto(roomsAvailable);

            response.setStatusCode(200);
            response.setMessage("Deleted Successfully!");
            response.setRoomList(roomsDto);
        }catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllAvailableRooms() {
        return null;
    }
}
