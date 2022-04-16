package com.ngoconnect.NGOSERVICE.VO;

import com.ngoconnect.NGOSERVICE.entity.NgoUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private NgoUser ngoUser;
	private Donation donation;
	

}
