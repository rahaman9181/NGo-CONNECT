package com.ngoconnect.USERSERVICE.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ngoconnect.USERSERVICE.VO.Donation;
import com.ngoconnect.USERSERVICE.VO.NgoUser;
import com.ngoconnect.USERSERVICE.VO.UserLogin;
import com.ngoconnect.USERSERVICE.entity.User;
import com.ngoconnect.USERSERVICE.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}
	public Optional<User> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	public List<User> findAllByAdmin() {
		// TODO Auto-generated method stub
		return userRepository.findByIsAdmin(true);
	}
	public List<User> findAllByUser() {
		// TODO Auto-generated method stub
		return userRepository.findByIsAdmin(false);
	}
	public User makeAdmin(Long id) {
		// TODO Auto-generated method stub
		
		 Optional<User> user = userRepository.findById(id);
		 if(user != null) {
			 user.get().setIsAdmin(true);
			 userRepository.save(user.get());
		 }
		return user.get();
	}
	public List<NgoUser> findAllApprovedNgos() {
	
		  ResponseEntity<NgoUser[]> responseEntity = 
				    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
				  restTemplate.getForEntity("http://NGO-SERVICE/ngo/approved", NgoUser[].class);
				  NgoUser[] userArray = responseEntity.getBody();
				 
				 
				  return Arrays.asList(userArray);
	}
	public List<Donation> findAllDonations() {
		// TODO Auto-generated method stub
		ResponseEntity<Donation[]> responseEntity = 
			   // restTemplate.getForEntity("http://localhost:8300/donations/list", Donation[].class);
				 restTemplate.getForEntity("http://TRANSACTION-SERVICE/donations/list", Donation[].class);
			  Donation[] userArray = responseEntity.getBody();
			
			  return Arrays.asList(userArray);
	}
	public List<NgoUser> findAllNotApprovedNgos() {
		// TODO Auto-generated method stub
		ResponseEntity<NgoUser[]> responseEntity = 
				restTemplate.getForEntity("http://NGO-SERVICE/ngo/notapproved", NgoUser[].class);
		  NgoUser[] userArray = responseEntity.getBody();
		
		  return Arrays.asList(userArray);
		
	}
	public NgoUser approveNgo(Long adminId, Long ngoId) {
		// TODO Auto-generated method stub
		
		  NgoUser ngoUser = restTemplate.exchange(
			         "http://NGO-SERVICE/ngo/approveNgo/"+adminId + "/"+ngoId, HttpMethod.PUT, null, NgoUser.class).getBody();
		return ngoUser;
	}
	public User login(UserLogin userLogin) {
		// TODO Auto-generated method stub
		System.err.println(userLogin);
		User user = userRepository.findByEmail(userLogin.getEmail());
		System.err.println(user.getPassword());
		if(user != null && (user.getPassword().equals(userLogin.getPassword()))) {
			
			
				
				return user;
			
		}
		
		return null;
	}

}
