package com.ngoconnect.USERSERVICE.VO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NgoUser {
	
	
	
	private Long id;
	private String ngoNumber;
	private String ngoName;
	private String ngoCity;
	private int ngoSize;
	private Long ngoApprovedId;

}

