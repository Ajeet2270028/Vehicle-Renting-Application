package com.example.vra.entity;

import com.example.vra.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int userid;
 private String username;
 private String email;
 private String phoneNumber;
 private String password;
 private UserRole role;
 
 @OneToOne
 private Image profilePicture;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserRole getRole() {
	return role;
}
public void setRole(UserRole role) {
	this.role = role;
}
public Image getProfilePicture() {
	return profilePicture;
}
public void setProfilePicture(Image profilePicture) {
	this.profilePicture = profilePicture;
}
 
 
}
