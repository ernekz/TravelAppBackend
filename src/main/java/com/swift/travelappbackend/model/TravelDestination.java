package com.swift.travelappbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_destinations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelDestination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String leavingDate;
    private String returningDate;
    private String description;
    private Long createdBy;


}
