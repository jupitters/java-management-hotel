package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.dto.RoomDto;
import com.jupitters.JupittersHotel.model.Room;
import com.jupitters.JupittersHotel.repo.BookingRepository;
import com.jupitters.JupittersHotel.repo.RoomRepository;
import com.jupitters.JupittersHotel.service.RoomService;
import com.jupitters.JupittersHotel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
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
        return List.of();
    }

    @Override
    public Response getAllRooms() {
        return null;
    }

    @Override
    public Response deleteRoom(Long roomId) {
        return null;
    }

    @Override
    public Response updateRoom(Long roomId, String roomType, BigDecimal roomprice, MultipartFile photo) {
        return null;
    }

    @Override
    public Response getRoomById(Long roomId) {
        return null;
    }

    @Override
    public Response getAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        return null;
    }

    @Override
    public Response getAllAvailableRooms() {
        return null;
    }
}
