package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.user;

public interface userRepo extends JpaRepository<user, Integer>{
	
	user findByEmail(String email);

}