package com.ngoconnect.NGOSERVICE.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngoconnect.NGOSERVICE.entity.NgoUser;

public interface NgoRepository extends JpaRepository<NgoUser, Long> {

	//NgoUser findById(Long id);
	NgoUser findByNgoNumber(String ngoNumber);
	List<NgoUser> findByNgoApprovedId(Long ngoApprovedId);
	List<NgoUser> findByNgoApprovedIdIsNull();
	List<NgoUser> findByNgoApprovedIdIsNotNull();

}
