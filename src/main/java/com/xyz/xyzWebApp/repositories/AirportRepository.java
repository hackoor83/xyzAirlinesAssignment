package com.xyz.xyzWebApp.repositories;

import com.xyz.xyzWebApp.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
