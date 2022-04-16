package com.ngoconnect.TRANSACTIONSERVICE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngoconnect.TRANSACTIONSERVICE.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{

	List<Donation> findByDonatedBy(Long id);

	List<Donation> findByDonatedTo(Long id);

	List<Donation> findByIsDonationAcceptedIsNotNull();

	List<Donation> findByIsDonationAcceptedIsNull();
	List<Donation> findByDonatedToAndIsDonationAcceptedIsNull(Long id);

}
