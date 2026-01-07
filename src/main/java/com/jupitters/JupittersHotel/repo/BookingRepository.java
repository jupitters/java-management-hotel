package com.jupitters.JupittersHotel.repo;

import com.jupitters.JupittersHotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Long, Booking> {
}
