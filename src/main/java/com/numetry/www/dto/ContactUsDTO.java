package com.numetry.www.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ContactUsDTO 
{
	private String name;
	
	private String email;
	
	@Lob
	private String message;
}
