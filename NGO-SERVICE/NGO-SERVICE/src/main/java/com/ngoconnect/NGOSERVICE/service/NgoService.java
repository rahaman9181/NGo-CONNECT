package com.ngoconnect.NGOSERVICE.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ngoconnect.NGOSERVICE.VO.Donation;
import com.ngoconnect.NGOSERVICE.VO.ResponseTemplateVO;
import com.ngoconnect.NGOSERVICE.entity.NgoUser;
import com.ngoconnect.NGOSERVICE.repository.NgoRepository;

@Service
public class NgoService {

	@Autowired
	private NgoRepository ngoRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public NgoUser saveNgoUser(NgoUser ngoUser) {
		// TODO Auto-generated method stub
		return ngoRepository.save(ngoUser);
	}

	public Optional<NgoUser> findByNgoUserId(Long id) {
		// TODO Auto-generated method stub
		System.err.println("Ngo with numner" + ngoRepository.findByNgoNumber("123456789"));
		System.err.println("Ngo with approver is as 1 "+ ngoRepository.findByNgoApprovedId((long) 1));
		System.err.println("Ngo with approver with null "+ ngoRepository.findByNgoApprovedIdIsNull());
		return ngoRepository.findById(id);
	}

	public List<NgoUser> findByApprovedId(Long id) {
		// TODO Auto-generated method stub
		return ngoRepository.findByNgoApprovedId(id);
		
	}

	public List<NgoUser> findByApprovedIdIsNotNull() {
		// TODO Auto-generated method stub
		return ngoRepository.findByNgoApprovedIdIsNotNull();
	}

	public List<NgoUser> findByApprovedIdIsNull() {
		// TODO Auto-generated method stub
		return ngoRepository.findByNgoApprovedIdIsNull();
	}

	public ResponseTemplateVO acceptDonation(Long ngoId, Long transactionId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		//= restTemplate.put("http://localhost:8300/donations/acceptDonation/"+transactionId,
			//							Donation.class);
		//donation = restTemplate.put("http://localhost:8300/donations/acceptDonation/"+transactionId, null);
		 Donation donation = restTemplate.exchange(
		         //"http://localhost:8300/donations/acceptDonation/"+transactionId, HttpMethod.PUT, null, Donation.class).getBody();
				 "http://DONATION-SERVICE/donations/acceptDonation/"+transactionId, HttpMethod.PUT, null, Donation.class).getBody();
		 vo.setNgoUser(ngoRepository.findById(ngoId).get());
		 vo.setDonation(donation);
		return vo;
	}

	public List<NgoUser> findAll() {
		// TODO Auto-generated method stub
		return ngoRepository.findAll();
	}

	public NgoUser approvedngo(Long adminId, Long ngoId) {
		// TODO Auto-generated method stub
		Optional<NgoUser> ngoUser = ngoRepository.findById(ngoId);
		if(ngoUser!=null) {
			 ngoUser.get().setNgoApprovedId(adminId);
			 ngoRepository.save(ngoUser.get());
		}
		
		return ngoUser.get();
	}


	
	
	
}
