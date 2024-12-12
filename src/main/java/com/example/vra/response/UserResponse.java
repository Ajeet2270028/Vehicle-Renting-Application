package com.example.vra.response;

import com.example.vra.enums.UserRole;

public class UserResponse {
	 private int userid;
	 private String username;
	 private String email;
	 private String phoneNumber;
	 
	 private UserRole role;
	 
//	 @OneToOne
//	 private Image profilePicture;
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
	
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
}
