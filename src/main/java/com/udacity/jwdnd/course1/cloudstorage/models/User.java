package com.udacity.jwdnd.course1.cloudstorage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor @RequiredArgsConstructor @Data
public class User {
    private Integer id; // Unfortunately cannot be final, as MyBatis needs to use a setter during insert.
    private String username;
    private String salt; // Unfortunately cannot be final, as, instead of creating a new user object, we can just edit the one grabbed directly from the form.
    private String password;
    private String firstName;
    private String lastName;
}