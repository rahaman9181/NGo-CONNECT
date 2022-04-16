package com.ngoconnect.TRANSACTIONSERVICE.controller;

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

import com.ngoconnect.TRANSACTIONSERVICE.VO.DonationUser;
import com.ngoconnect.TRANSACTIONSERVICE.entity.Donation;
import com.ngoconnect.TRANSACTIONSERVICE.service.DonationService;



@RestController
@RequestMapping("/donations")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	
	@PostMapping("/save")
	public Donation makeDonation(@RequestBody Donation donation) {
		return donationService.makeDonation(donation);
		
	}
	
	
	@GetMapping("/{id}")
	public Optional<Donation> getDonationById(@PathVariable("id") Long id) {
		return donationService.getDonationById(id);
		
	}
	
	
	@GetMapping("/list")
	public List<Donation> findAllDonations(){
		return donationService.findAllDonations();
	}
	
	@GetMapping("/donatedby/{id}")
	public List<Donation> findByDonatedBy(@PathVariable("id") Long id){
		return donationService.findByDonatedBy(id);
	}
	
	
	@GetMapping("/donatedbyNgoName/{id}")
	public List<DonationUser> findByDonatedByNew(@PathVariable("id") Long id){
		return donationService.findByDonatedByNew(id);
	}
	
	@GetMapping("/donatedto/{id}")
	public List<Donation> findByDonatedTo(@PathVariable("id") Long id){
		return donationService.findByDonatedTo(id);
	}
	
	@GetMapping("/donatedToByName/{id}")
	public List<DonationUser> findByDonatedToByName(@PathVariable("id") Long id){
		return donationService.findByDonatedToByName(id);
	}
	
	@GetMapping("/accepted")
	public List<Donation> findAllDonationsAccepted(){
		return donationService.findAllDonationsAccepted();
	}
	
	@GetMapping("/acceptedByName")
	public List<DonationUser> findAllDonationsAccceptedByName(){
		return donationService.findAllDonationsAccceptedByName();
	}
	@GetMapping("/notaccepted")
	public List<Donation> findAllDonationsNotAccepted(){
		return donationService.findAllDonationsNotAccepted();
	}
	@GetMapping("/notaccepted/{id}")
	public List<Donation> findAllDonationsNotAcceptedById(@PathVariable Long id){
		return donationService.findAllDonationsByIdNotAccepted(id);
	}
	
	
	@PutMapping("/acceptDonation/{id}")
	public Donation acceptDonation(@PathVariable("id") Long id) {
		return donationService.acceptDonation(id);
	}
	
	@GetMapping("/donationsByName")
	public List<DonationUser> findAllDonationsNew(){
		return donationService.findAllDonationsNew();
	}
	

}
