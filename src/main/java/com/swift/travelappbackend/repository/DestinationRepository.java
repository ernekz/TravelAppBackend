package com.swift.travelappbackend.repository;

import com.swift.travelappbackend.model.TravelDestination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<TravelDestination, Long> {
}
