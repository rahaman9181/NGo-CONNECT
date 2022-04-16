package com.ngoconnect.TRANSACTIONSERVICE.VO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private Boolean isAdmin;
	private Long number;

}
