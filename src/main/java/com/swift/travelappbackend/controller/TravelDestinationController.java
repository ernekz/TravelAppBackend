package com.swift.travelappbackend.controller;


import com.swift.travelappbackend.dto.DestinationRequest;
import com.swift.travelappbackend.service.TravelDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/travel")
@RequiredArgsConstructor
public class TravelDestinationController {

    private final TravelDestinationService destinationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createDestination(@RequestBody DestinationRequest destinationRequest){
        destinationService.createDestination(destinationRequest);
        return "Destination has been created";
    }

    @DeleteMapping("/{uid}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteDestination(@PathVariable Long uid){
        destinationService.deleteDestination(uid);
        return "Destination has been deleted";
    }

    @PutMapping
    public String updateDestination(@RequestBody DestinationRequest destinationRequest, Long uid){
        destinationService.updateDestination(destinationRequest, uid);
        return "Destination has been successfully updated";
    }

}
