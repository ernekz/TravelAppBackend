package com.swift.travelappbackend.controller;


import com.swift.travelappbackend.model.TravelDestination;
import com.swift.travelappbackend.service.TravelDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/travel")
public class TravelDestinationController {

    @Autowired
    private TravelDestinationService travelDestinationService;

    @PostMapping("/save")
    public String saveUser(@RequestBody TravelDestination destination) throws ExecutionException, InterruptedException {
        return travelDestinationService.saveTravelDestination(destination);
    }

    @GetMapping("/{name}")
    public TravelDestination getDetails(@PathVariable String id) throws ExecutionException, InterruptedException {
        return travelDestinationService.getTravelDetails(id);
    }

    @GetMapping("/getall")
    public List<TravelDestination> getAllTravelDestinations() throws ExecutionException, InterruptedException {
        return travelDestinationService.getTravels();
    }

    @PutMapping("/update")
    public String updateTravel(@RequestBody TravelDestination destination) throws ExecutionException, InterruptedException {
        return travelDestinationService.updateTravel(destination);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteTravel(@PathVariable String name){
        return travelDestinationService.deleteTravel(name);
    }

}
