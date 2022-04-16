package com.ngoconnect.NGOSERVICE.controller;

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

import com.ngoconnect.NGOSERVICE.VO.ResponseTemplateVO;
import com.ngoconnect.NGOSERVICE.entity.NgoUser;
import com.ngoconnect.NGOSERVICE.service.NgoService;

@RestController
@RequestMapping("/ngo")
public class NgoController {
	
	@Autowired
	private NgoService ngoService;
	
	@PostMapping("/save")
	public NgoUser saveNgoUser(@RequestBody NgoUser ngoUser) {
		return ngoService.saveNgoUser(ngoUser);
		
	}
	
	@GetMapping("/{id}")
	public Optional<NgoUser> findByNgoUserId(@PathVariable("id") Long id) {
		
		return ngoService.findByNgoUserId(id);
	}
	
	@GetMapping("/approved/{id}")
	public List<NgoUser> findByApprovedId(@PathVariable("id") Long id){
		return ngoService.findByApprovedId(id);
	}
	@GetMapping("/approved")
	public List<NgoUser> findByApprovedIdIsNotNull(){
		return ngoService.findByApprovedIdIsNotNull();
	}
	@GetMapping("/notapproved")
	public List<NgoUser> findByApprovedIdIsNull(){
		return ngoService.findByApprovedIdIsNull();
	}
	@GetMapping("/list")
	public List<NgoUser> findAll(){
		return ngoService.findAll();
	}
	
	
	@PutMapping("/approveNgo/{adminId}/{ngoId}")
	public NgoUser approveNgo(@PathVariable("adminId") Long adminId,@PathVariable("ngoId") Long ngoId) {
		return ngoService.approvedngo(adminId,ngoId);
	}
	
	@PutMapping("/acceptDonation/{ngoId}/{transId}")
	public ResponseTemplateVO acceptDonation(@PathVariable("ngoId") Long ngoId,@PathVariable("transId") Long transactionId) {
		return ngoService.acceptDonation(ngoId,transactionId);
	}
	

}
