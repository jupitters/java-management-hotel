package com.jupitters.JupittersHotel.repo;

import com.jupitters.JupittersHotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
