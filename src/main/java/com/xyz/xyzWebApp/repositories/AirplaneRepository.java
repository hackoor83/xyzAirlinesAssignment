package com.xyz.xyzWebApp.repositories;

import com.xyz.xyzWebApp.models.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
