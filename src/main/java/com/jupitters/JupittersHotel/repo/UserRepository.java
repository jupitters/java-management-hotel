package com.jupitters.JupittersHotel.repo;

import com.jupitters.JupittersHotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
