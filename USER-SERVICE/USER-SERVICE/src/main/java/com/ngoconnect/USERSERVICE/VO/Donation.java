package com.ngoconnect.USERSERVICE.VO;

import java.util.Date;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
	

	private Long id;
	private Long donatedBy;
	private Long donatedTo;
	private String donationGoods;
	private String donationGoodsUnits;
	private Date donationDate;
	private Date donationApprovedDate;
	private Boolean isDonationAccepted;
	

}
