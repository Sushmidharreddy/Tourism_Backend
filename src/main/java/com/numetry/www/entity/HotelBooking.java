package com.numetry.www.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table
@Data
public class HotelBooking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hotelBookingId;
	@NotBlank(message="to book hotel, hoteNname is required")
	@Size(min=6 , max=20, message="name must be between 6 to 30 characters")
	@Pattern(regexp="^[a-zA-z]{6,20}$", message="name must contains alphabets")
	private String userName;
	
//	@NotBlank(message="to book hotel, hoteNname is required")
//	@Size(min=6 , max=20, message="name must be between 6 to 30 characters")
//	@Pattern(regexp="^[a-zA-z]{6,20}$", message="name must contains alphabets")
	private String guestName1;
	
//	@NotBlank(message="to book hotel, hoteNname is required")
//	@Size(min=6 , max=20, message="name must be between 6 to 30 characters")
//	@Pattern(regexp="^[a-zA-z]{6,20}$", message="name must contains alphabets")
	private String guestName2;
	
//	@NotBlank(message="to book hotel, hoteNname is required")
//	@Size(min=6 , max=20, message="name must be between 6 to 30 characters")
//	@Pattern(regexp="^[a-zA-z]{6,20}$", message="name must contains alphabets")
	private String guestName3;
	
	
	@NotBlank(message="mobile is required")
	@Size(min=10, max=10, message="mobileNumber must be 10 digits")
	@Pattern(regexp="^[6-9][0-9]{9}$", message="invalid mobile number")
	private String mobileNumber;
	
	@NotBlank(message="aadhar number is required")
	@Size(min=12, max=12, message="Aadhar number must be 10 digits")
	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$")
	private String userAadharNumber;
	
//	@NotBlank(message="aadhar number is required")
//	@Size(min=12, max=12, message="Aadhar number must be 10 digits")
//	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$")
	private String guestAadharNumber1;
	
//	@NotBlank(message="aadhar number is required")
//	@Size(min=12, max=12, message="Aadhar number must be 10 digits")
//	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$")
	private String guestAadharNumber2;
	
	
//	@NotBlank(message="aadhar number is required")
//	@Size(min=12, max=12, message="Aadhar number must be 10 digits")
//	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$")
	private String guestAadharNumber3;
	
 
	
	@NotBlank(message="email is required")
	@Pattern(regexp = "^(?!.?\\.\\.)(?!.?\\.(|\\.|\\.))([a-zA-Z0-9]+[a-zA-Z]*)(?:[.][a-zA-Z0-9]+)?(?:[.]?[a-zA-Z0-9]+)?@[a-zA-Z.]+(?:[a-zA-Z0-9]+)?\\.[a-zA-Z]{2,3}$", message="Invalid email address")
	private String email;
	
	@NotBlank(message="Hotel Name is required")
	private String hotelName;
	
//	@NotBlank(message = "bookingDate is required")
	private LocalDate bookingDate;
	
//	@NotBlank(message="bookingTime is required")
	private LocalTime bookingTime;
	
//	@NotBlank(message= "arivalDate is required")
	private LocalDate arivalDate;
	
//	@NotBlank(message="vacatingDate is required")
	private LocalDate vacatingDate;
	
//	@NotBlank(message="price must be required")
	private String price;

	
	
	
	
	
}
