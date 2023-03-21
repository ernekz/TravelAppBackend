package com.swift.travelappbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String email;
    private boolean emailVerification;
    private String password;
    private String phoneNumber;
    private boolean isDisabled;

    private String displayName;
    private String lastName;

}
