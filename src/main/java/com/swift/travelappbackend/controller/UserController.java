package com.swift.travelappbackend.controller;

import com.swift.travelappbackend.dto.LoginRequest;
import com.swift.travelappbackend.model.User;
import com.swift.travelappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String saveUser(@RequestBody User user) {
        return userService.creatUser(user);
    }

    /* @GetMapping("/users/{name}")
     public User getUser(@PathVariable String name) throws ExecutionException, InterruptedException {
         return userService.getUserDetails(name);
     }
 */
    @PutMapping("/users/{uid}")
    public String updateUser(@RequestBody User user, @PathVariable String uid){
        return userService.updateUser(user, uid);
    }

    @DeleteMapping("/users/{uid}")
    public String deleteUser(@PathVariable String uid){
        return userService.deleteUser(uid);
    }

/*
    @GetMapping("/users")
    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userService.getUsers();
    }*/

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest){
        return userService.signInWithEmail(loginRequest);
    }

}
