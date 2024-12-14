package com.example.vra.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.vra.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  
	@Query("Select u.profilePicture.imageid from User u where u.userid= :userid")
	Integer getProfilePictureByuserid(int userid);
	
	
}
