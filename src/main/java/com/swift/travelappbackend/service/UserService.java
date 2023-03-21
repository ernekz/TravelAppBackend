package com.swift.travelappbackend.service;


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.*;
import com.google.firebase.auth.internal.FirebaseCustomAuthToken;
import com.google.firebase.cloud.FirestoreClient;
import com.swift.travelappbackend.dto.LoginRequest;
import com.swift.travelappbackend.model.User;
import com.swift.travelappbackend.repository.FirebaseConnection;
import io.netty.handler.codec.http.cookie.Cookie;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    //Create the user with Email and password
    public String creatUser(User user){

        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setEmailVerified(user.isEmailVerification())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber());

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return "User created successful " + userRecord.getUid();

        } catch (FirebaseAuthException e) {

            return "There was an error with a code " + e.getMessage();

        }
    }


    //Update the current user
    public String updateUser(User user, String uid){

        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(user.getEmail())
                .setEmailVerified(user.isEmailVerification())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber());

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);
            return "Successfully update user with id: " + userRecord.getUid();
        } catch (FirebaseAuthException e){
            return "There was an error with a code " + e.getMessage();
        }
    }

    public String deleteUser(String uid) {
        try {
            FirebaseAuth.getInstance().deleteUser(uid);
            return "Sucessfully deleted the user";

        } catch (FirebaseAuthException e){
            return "There was an error and a message is: " + e.getMessage();
        }

    }

    //Login with email and password and as a reponse generating the sessionToken and giving back to client only works with email
    // TODO:make it check properly if the user is registered and he can login.
    /*
    public ResponseEntity<?> signInWithEmail(LoginRequest request) {

        try {
            FirebaseAuth.getInstance().
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(request.getEmail());
            String sessionCookie = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
            return new ResponseEntity<>(sessionCookie, HttpStatus.ACCEPTED);

        } catch (FirebaseAuthException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/

}
