package com.jupitters.JupittersHotel.service.impl;

import com.jupitters.JupittersHotel.dto.LoginRequest;
import com.jupitters.JupittersHotel.dto.Response;
import com.jupitters.JupittersHotel.dto.UserDto;
import com.jupitters.JupittersHotel.exception.ResourceNotFoundException;
import com.jupitters.JupittersHotel.model.User;
import com.jupitters.JupittersHotel.repo.UserRepository;
import com.jupitters.JupittersHotel.service.UserService;
import com.jupitters.JupittersHotel.utils.JWTUtils;
import com.jupitters.JupittersHotel.utils.Utils;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Response register(User user) {
        Response response = new Response();
        try{
            if(user.getRole() == null || user.getRole().isBlank()){
                user.setRole("ROLE_USER");
            }
            if(userRepository.existsByEmail(user.getEmail())){
                throw new RuntimeException(user.getEmail() + " is already registered");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            UserDto userDto = Utils.mapUserEntityToDto(savedUser);
            response.setStatusCode(201);
            response.setUser(userDto);
        } catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        Response response = new Response();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
            String token = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(token);
            response.setRole(user.getRole());
            response.setExpirationTime("7 days");
            response.setMessage("Login successful!");

        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllUsers() {
        Response response = new Response();
        try{
            List<User> users = userRepository.findAll();
            List<UserDto> usersDto = Utils.mapUserListToDto(users);
            response.setStatusCode(200);
            response.setMessage("Users found!");
            response.setUserList(usersDto);
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response getUserBookingHistory(Long userId) {
        Response response = new Response();
        try{
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
            UserDto userDto = Utils.mapUserEntityToDtoBookingsAndRooms(user);
            response.setStatusCode(200);
            response.setMessage("Bookings found!");
            response.setUser(userDto);
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response deleteUser(Long userId) {
        Response response = new Response();
        try{
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
            userRepository.deleteById(userId);
            response.setStatusCode(200);
            response.setMessage("Deleted successfully");
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response getUserById(Long userId) {
        Response response = new Response();
        try{
            List<User> users = userRepository.findAll();
            List<UserDto> usersDto = Utils.mapUserListToDto(users);
            response.setStatusCode(200);
            response.setMessage("Users found!");
            response.setUserList(usersDto);
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response getMyInfo(Long userId) {
        Response response = new Response();
        try{
            List<User> users = userRepository.findAll();
            List<UserDto> usersDto = Utils.mapUserListToDto(users);
            response.setStatusCode(200);
            response.setMessage("Users found!");
            response.setUserList(usersDto);
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
