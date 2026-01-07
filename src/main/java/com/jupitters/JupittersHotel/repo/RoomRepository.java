package com.jupitters.JupittersHotel.repo;

import com.jupitters.JupittersHotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Long, Room> {
}
