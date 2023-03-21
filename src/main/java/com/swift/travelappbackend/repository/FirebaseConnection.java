package com.swift.travelappbackend.repository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Service
public class FirebaseConnection {

    ClassLoader classLoader = FirebaseConnection.class.getClassLoader();

    @PostConstruct
    public void initiliaze(){
        try{
            File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
            FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
