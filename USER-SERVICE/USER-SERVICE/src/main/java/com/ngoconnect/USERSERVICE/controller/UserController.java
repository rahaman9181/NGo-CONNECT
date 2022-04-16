package com.ngoconnect.USERSERVICE.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoconnect.USERSERVICE.VO.Donation;
import com.ngoconnect.USERSERVICE.VO.NgoUser;
import com.ngoconnect.USERSERVICE.VO.UserLogin;
import com.ngoconnect.USERSERVICE.entity.User;
import com.ngoconnect.USERSERVICE.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public Optional<User> findByUserId(@PathVariable("id") Long id) {
		return userService.findByUserId(id);
		
	}
	
	@GetMapping("/list")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	//To get admin users
	@GetMapping("/admin")
	public List<User> findAllByAdmin(){
		return userService.findAllByAdmin();
	}
	
	//To get only the non-admin users
	@GetMapping("/user")
	public List<User> findAllByUser(){
		return userService.findAllByUser();
	}
	
	@PutMapping("/makeadmin/{id}")
	public User makeAdmin(@PathVariable Long id) {
		return userService.makeAdmin(id);
	}
	
	
	//To get only approved ngo's for the user
	@GetMapping("/getapprovedngos")
	public List<NgoUser> findAllApprovedNgos(){
		return userService.findAllApprovedNgos();
	}

	//To get only not approved ngo's for the user
	@GetMapping("/getnotapprovedngos")
	public List<NgoUser> findAllNotApprovedNgos(){
		return userService.findAllNotApprovedNgos();
	}
	
	@GetMapping("/getdonations")
	public List<Donation> findAllDonations(){
		return userService.findAllDonations();
	}
	
	//Approve Ngo through another service
	@PutMapping("/approveNgo/{adminId}/{ngoId}")
	public NgoUser approveNgo(@PathVariable("adminId") Long adminId, @PathVariable("ngoId") Long ngoId) {
		return userService.approveNgo(adminId,ngoId);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody UserLogin userLogin) {
		return userService.login(userLogin);
		
	}

}
