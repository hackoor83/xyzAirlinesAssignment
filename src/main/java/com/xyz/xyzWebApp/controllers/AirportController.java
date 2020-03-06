package com.xyz.xyzWebApp.controllers;

import com.xyz.xyzWebApp.models.Airplane;
import com.xyz.xyzWebApp.models.Airport;
import com.xyz.xyzWebApp.repositories.AirplaneRepository;
import com.xyz.xyzWebApp.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }

    @PostMapping
    public void addAirport(@RequestBody Airport airport){
        airportRepository.save(airport);
    }

    @DeleteMapping("{id}")
    public void removeAirport(@PathVariable Long id){
        airportRepository.deleteById(id);
    }

}
