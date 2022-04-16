package com.ngoconnect.USERSERVICE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngoconnect.USERSERVICE.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByIsAdmin(boolean b);
	
	User findByEmail(String email);
	
	

}
