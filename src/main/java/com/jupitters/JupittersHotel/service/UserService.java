package com.jupitters.JupittersHotel.service;

import com.jupitters.JupittersHotel.dto.LoginRequest;
import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.model.User;

public interface UserService {
    Response register(User loginRequest);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response getUserBookingHistory(Long userId);
    Response deleteUser(Long userId);
    Response getUserById(Long userId);
    Response getMyInfo(Long userId);
}
