package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.LoginRequest;
import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.model.User;
import com.jupitters.JupittersHotel.repo.UserRepository;
import com.jupitters.JupittersHotel.service.UserService;
import com.jupitters.JupittersHotel.utils.JWTUtils;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Response register(User loginRequest) {
        return null;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response getAllUsers() {
        return null;
    }

    @Override
    public Response getUserBookingHistory(Long userId) {
        return null;
    }

    @Override
    public Response deleteUser(Long userId) {
        return null;
    }

    @Override
    public Response getUserById(Long userId) {
        return null;
    }

    @Override
    public Response getMyInfo(Long userId) {
        return null;
    }
}
