package com.swift.travelappbackend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.swift.travelappbackend.repository.FirebaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@SpringBootApplication
public class TravelAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAppBackendApplication.class, args);
    }


}
