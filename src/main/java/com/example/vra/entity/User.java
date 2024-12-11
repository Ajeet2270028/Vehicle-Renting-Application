package com.example.vra.entity;

import com.example.vra.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
 @Id
 
 private int userid;
 private String username;
 private String email;
 private String phoneNumber;
 private String password;
 private UserRole role;
 private String profilePicture;
 
 
}
