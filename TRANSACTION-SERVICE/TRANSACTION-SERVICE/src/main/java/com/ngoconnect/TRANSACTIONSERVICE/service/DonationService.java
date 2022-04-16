package com.ngoconnect.TRANSACTIONSERVICE.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ngoconnect.TRANSACTIONSERVICE.entity.Donation;
import com.ngoconnect.TRANSACTIONSERVICE.repository.DonationRepository;
import com.ngoconnect.TRANSACTIONSERVICE.VO.DonationUser;
import com.ngoconnect.TRANSACTIONSERVICE.VO.NgoUser;
import com.ngoconnect.TRANSACTIONSERVICE.VO.User;

@Service
public class DonationService {
	
	@Autowired
	private DonationRepository donationRepository;
	
	
	@Autowired
	private RestTemplate restTemplate;

	public Donation makeDonation(Donation donation) {
		// TODO Auto-generated method stub
		donation.setDonationDate(new Date());
		return donationRepository.save(donation);
	}

	public Optional<Donation> getDonationById(Long id) {
		// TODO Auto-generated method stub
		return donationRepository.findById(id);
	}

	public List<Donation> findAllDonations() {
		// TODO Auto-generated method stub
		return donationRepository.findAll();
	}

	public List<Donation> findByDonatedBy(Long id) {
		// TODO Auto-generated method stub
		ResponseEntity<NgoUser[]> responseEntity = 
			    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
			  restTemplate.getForEntity("http://NGO-SERVICE/ngo/list", NgoUser[].class);
				NgoUser[] userArray = responseEntity.getBody();
			  List<NgoUser> users = Arrays.asList(userArray);
			  //System.err.println(users);
			  
		return donationRepository.findByDonatedBy(id);
			  
	}
	public List<DonationUser> findByDonatedByNew(Long id) {
		// TODO Auto-generated method stub
		ResponseEntity<NgoUser[]> responseEntity = 
			    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
			  restTemplate.getForEntity("http://NGO-SERVICE/ngo/list", NgoUser[].class);
				NgoUser[] userArray = responseEntity.getBody();
		ResponseEntity<User[]> responseEntity2 = 
					    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
					  restTemplate.getForEntity("http://USER-SERVICE/user/list", User[].class);
						User[] userArray2 = responseEntity2.getBody();
			  List<User> users = Arrays.asList(userArray2);
			  List<NgoUser> ngousers = Arrays.asList(userArray);
			  List<DonationUser> donationUser = new ArrayList<>();
			  List<Donation> donation = donationRepository.findByDonatedBy(id);
			  for(int i = 0; i<donation.size(); i++) {
				  Long id1 = donation.get(i).getDonatedTo();
				  for(int j=0;j<ngousers.size(); j++) {
					  if(id1 == (ngousers.get(j).getId())){
						  DonationUser donationUserNew = new DonationUser();
						  donationUserNew.setId(donation.get(i).getId());
						  donationUserNew.setDonatedBy(donation.get(i).getDonatedBy());
						  donationUserNew.setDonatedToName(ngousers.get(j).getNgoName());
						  donationUserNew.setDonatedTo(donation.get(i).getDonatedTo());
						  donationUserNew.setDonationGoods(donation.get(i).getDonationGoods());
						  donationUserNew.setDonationGoodsUnits(donation.get(i).getDonationGoodsUnits());
						  donationUserNew.setDonationDate(donation.get(i).getDonationDate());
						  donationUserNew.setDonationApprovedDate(donation.get(i).getDonationApprovedDate());
						  donationUserNew.setIsDonationAccepted(donation.get(i).getIsDonationAccepted());
						  donationUser.add(donationUserNew);
						  
					  }
				  }
			  }
			  
			  for(int i=0; i<donationUser.size();i++) {
				  Long id2 = donationUser.get(i).getDonatedBy();
				  for(int j = 0; j<users.size();j++) {
					  if(id2 == (users.get(j)).getId()) {
						  donationUser.get(i).setDonatedByName(users.get(j).getEmail());
					  }
				  }
			  }
			  System.err.println(donationUser);
		return donationUser;
	}

	public List<Donation> findByDonatedTo(Long id) {
		// TODO Auto-generated method stub
		return donationRepository.findByDonatedTo(id);
	}
	
	public List<DonationUser> findByDonatedToByName(Long id){
		ResponseEntity<NgoUser[]> responseEntity = 
			    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
			  restTemplate.getForEntity("http://NGO-SERVICE/ngo/list", NgoUser[].class);
				NgoUser[] userArray = responseEntity.getBody();
		ResponseEntity<User[]> responseEntity2 = 
					    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
					  restTemplate.getForEntity("http://USER-SERVICE/user/list", User[].class);
						User[] userArray2 = responseEntity2.getBody();
			  List<User> users = Arrays.asList(userArray2);
			  List<NgoUser> ngousers = Arrays.asList(userArray);
			  List<DonationUser> donationUser = new ArrayList<>();
			  List<Donation> donation = donationRepository.findByDonatedTo(id);
			  for(int i = 0; i<donation.size(); i++) {
				  Long id1 = donation.get(i).getDonatedTo();
				  for(int j=0;j<ngousers.size(); j++) {
					  if(id1 == (ngousers.get(j).getId())){
						  DonationUser donationUserNew = new DonationUser();
						  donationUserNew.setId(donation.get(i).getId());
						  donationUserNew.setDonatedBy(donation.get(i).getDonatedBy());
						  donationUserNew.setDonatedToName(ngousers.get(j).getNgoName());
						  donationUserNew.setDonatedTo(donation.get(i).getDonatedTo());
						  donationUserNew.setDonationGoods(donation.get(i).getDonationGoods());
						  donationUserNew.setDonationGoodsUnits(donation.get(i).getDonationGoodsUnits());
						  donationUserNew.setDonationDate(donation.get(i).getDonationDate());
						  donationUserNew.setDonationApprovedDate(donation.get(i).getDonationApprovedDate());
						  donationUserNew.setIsDonationAccepted(donation.get(i).getIsDonationAccepted());
						  donationUser.add(donationUserNew);
						  
					  }
				  }
			  }
			  
			  for(int i=0; i<donationUser.size();i++) {
				  Long id2 = donationUser.get(i).getDonatedBy();
				  for(int j = 0; j<users.size();j++) {
					  if(id2 == (users.get(j)).getId()) {
						  donationUser.get(i).setDonatedByName(users.get(j).getEmail());
					  }
				  }
			  }
			  System.err.println(donationUser);
		return donationUser;
		
	}

	public List<Donation> findAllDonationsAccepted() {
		// TODO Auto-generated method stub
		return donationRepository.findByIsDonationAcceptedIsNotNull();
	}
	
	public List<DonationUser> findAllDonationsAccceptedByName(){
//		List<Donation> donations = donationRepository.findByIsDonationAcceptedIsNotNull();
		ResponseEntity<NgoUser[]> responseEntity = 
			    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
			  restTemplate.getForEntity("http://NGO-SERVICE/ngo/list", NgoUser[].class);
				NgoUser[] userArray = responseEntity.getBody();
		ResponseEntity<User[]> responseEntity2 = 
					    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
					  restTemplate.getForEntity("http://USER-SERVICE/user/list", User[].class);
						User[] userArray2 = responseEntity2.getBody();
			  List<User> users = Arrays.asList(userArray2);
			  List<NgoUser> ngousers = Arrays.asList(userArray);
			  List<DonationUser> donationUser = new ArrayList<>();
			  List<Donation> donation = donationRepository.findByIsDonationAcceptedIsNotNull();
			  for(int i = 0; i<donation.size(); i++) {
				  Long id1 = donation.get(i).getDonatedTo();
				  for(int j=0;j<ngousers.size(); j++) {
					  if(id1 == (ngousers.get(j).getId())){
						  DonationUser donationUserNew = new DonationUser();
						  donationUserNew.setId(donation.get(i).getId());
						  donationUserNew.setDonatedBy(donation.get(i).getDonatedBy());
						  donationUserNew.setDonatedToName(ngousers.get(j).getNgoName());
						  donationUserNew.setDonatedTo(donation.get(i).getDonatedTo());
						  donationUserNew.setDonationGoods(donation.get(i).getDonationGoods());
						  donationUserNew.setDonationGoodsUnits(donation.get(i).getDonationGoodsUnits());
						  donationUserNew.setDonationDate(donation.get(i).getDonationDate());
						  donationUserNew.setDonationApprovedDate(donation.get(i).getDonationApprovedDate());
						  donationUserNew.setIsDonationAccepted(donation.get(i).getIsDonationAccepted());
						  donationUser.add(donationUserNew);
						  
					  }
				  }
			  }
			  
			  for(int i=0; i<donationUser.size();i++) {
				  Long id2 = donationUser.get(i).getDonatedBy();
				  for(int j = 0; j<users.size();j++) {
					  if(id2 == (users.get(j)).getId()) {
						  donationUser.get(i).setDonatedByName(users.get(j).getEmail());
					  }
				  }
			  }
			  System.err.println(donationUser);
		return donationUser;
	}

	public List<Donation> findAllDonationsNotAccepted() {
		// TODO Auto-generated method stub
		return donationRepository.findByIsDonationAcceptedIsNull();
	}

	public Donation acceptDonation(Long id) {
		// TODO Auto-generated method stub
		Donation donation = donationRepository.findById(id).get();
		donation.setDonationApprovedDate(new Date());
		donation.setIsDonationAccepted(true);
		donationRepository.save(donation);
		return donation;
	}

	public List<Donation> findAllDonationsByIdNotAccepted(Long id) {
		// TODO Auto-generated method stub
		return donationRepository.findByDonatedToAndIsDonationAcceptedIsNull(id);
	}
	
	
	public List<DonationUser> findAllDonationsNew() {
		// TODO Auto-generated method stub
		ResponseEntity<NgoUser[]> responseEntity = 
			    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
			  restTemplate.getForEntity("http://NGO-SERVICE/ngo/list", NgoUser[].class);
				NgoUser[] userArray = responseEntity.getBody();
		ResponseEntity<User[]> responseEntity2 = 
					    //restTemplate.getForEntity("http://localhost:8100/ngo/approved", NgoUser[].class);
					  restTemplate.getForEntity("http://USER-SERVICE/user/list", User[].class);
						User[] userArray2 = responseEntity2.getBody();
			  List<User> users = Arrays.asList(userArray2);
			  List<NgoUser> ngousers = Arrays.asList(userArray);
			  List<DonationUser> donationUser = new ArrayList<>();
			  List<Donation> donation = donationRepository.findAll();
			  for(int i = 0; i<donation.size(); i++) {
				  Long id1 = donation.get(i).getDonatedTo();
				  for(int j=0;j<ngousers.size(); j++) {
					  if(id1 == (ngousers.get(j).getId())){
						  DonationUser donationUserNew = new DonationUser();
						  donationUserNew.setId(donation.get(i).getId());
						  donationUserNew.setDonatedBy(donation.get(i).getDonatedBy());
						  donationUserNew.setDonatedToName(ngousers.get(j).getNgoName());
						  donationUserNew.setDonatedTo(donation.get(i).getDonatedTo());
						  donationUserNew.setDonationGoods(donation.get(i).getDonationGoods());
						  donationUserNew.setDonationGoodsUnits(donation.get(i).getDonationGoodsUnits());
						  donationUserNew.setDonationDate(donation.get(i).getDonationDate());
						  donationUserNew.setDonationApprovedDate(donation.get(i).getDonationApprovedDate());
						  donationUserNew.setIsDonationAccepted(donation.get(i).getIsDonationAccepted());
						  donationUser.add(donationUserNew);
						  
					  }
				  }
			  }
			  
			  for(int i=0; i<donationUser.size();i++) {
				  Long id2 = donationUser.get(i).getDonatedBy();
				  for(int j = 0; j<users.size();j++) {
					  if(id2 == (users.get(j)).getId()) {
						  donationUser.get(i).setDonatedByName(users.get(j).getEmail());
					  }
				  }
			  }
			  System.err.println(donationUser);
		return donationUser;
	}
	
	

}
