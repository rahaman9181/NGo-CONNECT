package com.ngoconnect.TRANSACTIONSERVICE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long donatedBy;
	private Long donatedTo;
	private String donationGoods;
	private String donationGoodsUnits;
	private Date donationDate;
	private Date donationApprovedDate;
	private Boolean isDonationAccepted;
	

}
