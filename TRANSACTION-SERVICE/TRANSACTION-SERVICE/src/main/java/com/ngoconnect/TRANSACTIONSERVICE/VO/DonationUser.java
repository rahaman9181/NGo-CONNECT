package com.ngoconnect.TRANSACTIONSERVICE.VO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationUser {
	
	private Long id;
	private Long donatedBy;
	private String donatedByName;
	private String donatedToName;
	private Long donatedTo;
	private String donationGoods;
	private String donationGoodsUnits;
	private Date donationDate;
	private Date donationApprovedDate;
	private Boolean isDonationAccepted;

}
