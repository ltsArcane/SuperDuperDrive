package com.udacity.jwdnd.course1.cloudstorage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class User {
    private Integer id;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;
}