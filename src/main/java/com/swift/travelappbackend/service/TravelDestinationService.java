package com.swift.travelappbackend.service;


import com.swift.travelappbackend.dto.DestinationRequest;
import com.swift.travelappbackend.model.TravelDestination;
import com.swift.travelappbackend.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


@Service
@RequiredArgsConstructor
@Slf4j
public class TravelDestinationService {

    private final DestinationRepository destinationRepository;

    public void createDestination(DestinationRequest destinationRequest){

        TravelDestination travelDestination = TravelDestination.builder()
                .createdBy(destinationRequest.getCreatedBy())
                .country(destinationRequest.getCountry())
                .description(destinationRequest.getDescription())
                .city(destinationRequest.getCity())
                .leavingDate(destinationRequest.getLeavingDate())
                .returningDate(destinationRequest.getReturningDate())
                .build();

        destinationRepository.save(travelDestination);
        log.info("Destination {} is created", travelDestination.getId());

    }

    public void deleteDestination(Long uid){

        destinationRepository.deleteById(uid);
        log.info("Destionation sucessfully deleted");


    }


    public void updateDestination(DestinationRequest destinationRequest, Long uid) {
        TravelDestination travelDestination = destinationRepository.findById(uid)
                .orElseThrow(()-> new ResourceAccessException("Destinations not found"));

        travelDestination.setCity(destinationRequest.getCity());
        travelDestination.setCountry(destinationRequest.getCountry());
        travelDestination.setDescription(destinationRequest.getDescription());
        travelDestination.setLeavingDate(destinationRequest.getLeavingDate());
        travelDestination.setReturningDate(destinationRequest.getReturningDate());

        destinationRepository.save(travelDestination);
    }
}
