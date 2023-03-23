package com.swift.travelappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRequest {

    private Long id;
    private String country;
    private String city;
    private String leavingDate;
    private String returningDate;
    private String description;
    private Long createdBy;
}
