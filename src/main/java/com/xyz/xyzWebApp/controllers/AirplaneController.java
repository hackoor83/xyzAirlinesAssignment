package com.xyz.xyzWebApp.controllers;

import com.xyz.xyzWebApp.models.Airplane;
import com.xyz.xyzWebApp.models.Airport;
import com.xyz.xyzWebApp.repositories.AirplaneRepository;
import com.xyz.xyzWebApp.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {

    @Autowired
    AirplaneRepository airplaneRepository;
    @Autowired
    AirportRepository airportRepository;

    @GetMapping
    public List<Airplane> getPlanes(){
        return airplaneRepository.findAll();
    }

    @PostMapping
    public void addAirplane(@RequestBody Airplane airplane){
        airplaneRepository.save(airplane);
    }

    @DeleteMapping("{id}")
    public void removeAirplane(@PathVariable Long id){
        airplaneRepository.deleteById(id);
    }

    @PutMapping("/update/{airplaneId}/{airportId}")
    public void relocateAirplane(@PathVariable Long airplaneId, @PathVariable Long airportId){
        Airplane airplane = airplaneRepository.getOne(airplaneId);
        Airport airport = airportRepository.getOne(airportId);
        // Set the correct airport
        airplane.setAirport(airport);
        // update the fuel
        airplane.setFuelAmount(5);

        // save the airplane
        airplaneRepository.save(airplane);
//        airplane.setAirport(airportId);

    }

}
