package com.numetry.www.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.www.Repository.StateRepository;
import com.numetry.www.dto.ContactUsDTO;
import com.numetry.www.dto.CustumerDTO;
import com.numetry.www.dto.HotelBookingDTO;
import com.numetry.www.dto.StateDTO;
import com.numetry.www.entity.Category;
import com.numetry.www.entity.ContactUs;
import com.numetry.www.entity.Login;
import com.numetry.www.entity.Place;
import com.numetry.www.entity.State;
import com.numetry.www.service.ToursandTravelsService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("toursandtravels/api/v1")
public class ToursandTravelsController {
	@Autowired
	ToursandTravelsService toursandTravelsService;

	// To Save the Data while user SignUp and send an email upon successfull
	// registration
	@PostMapping("/register")
	public ResponseEntity<String> createCustumer(@Valid @RequestBody CustumerDTO custumerDTO)
			throws MessagingException {
		return toursandTravelsService.createCustumer(custumerDTO);
		// return ResponseEntity.status(HttpStatus.CREATED).body("User registered
		// successfully");
	}

	// To retrive all users data from signup table
	@GetMapping("/getusers")
	public ResponseEntity<List<CustumerDTO>> getCustumers() {
		return toursandTravelsService.getCustumers();

	}

	// Login Functionality
	@PostMapping("/login")
	public ResponseEntity<String> checkLogin(@Valid @RequestBody Login login) {
		return toursandTravelsService.checkLogin(login);
	}

	// update the userDetails
	@PutMapping("updateuser/{userName}")
	public ResponseEntity<String> updateUserDetails(@Valid @RequestBody CustumerDTO custumerDTO,
			@PathVariable String userName) {

		return toursandTravelsService.updateuser(custumerDTO, userName);
	}

	// Delete userDetails
	@DeleteMapping("deleteuser/{userName}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable String userName) {
		return toursandTravelsService.deleteUserDetails(userName);
	}

	@Autowired
	ModelMapper modelMapper;

	// to find the Details by stateName
	@GetMapping("/state/{stateName}")
	public StateDTO getStateByName(@PathVariable String stateName) {
		return toursandTravelsService.getStateByName(stateName);
	}

	// to save StateDetails
	@PostMapping("/post/state")
	public StateDTO postStateDetails(@RequestBody StateDTO state) {
		return toursandTravelsService.postStateDetails(state);
	}

	// to Store Category Details
	@PostMapping("post/category")
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		return toursandTravelsService.saveCategory(category);
	}

	// to Store CategoryDetails
	@PostMapping("post/place")
	public ResponseEntity<String> createPlace(@RequestBody Place place) {
		return toursandTravelsService.savePlace(place);
	}

	// to Store state, category and place at a time
	@PostMapping("post/AllatATime")
	public State saveAllatATime(@RequestBody StateDTO stateDTO) {
		System.out.println("Entered saveAllatATime controller method");
		State state = toursandTravelsService.saveAllatATime(stateDTO);
		System.out.println("Exiting saveAllatATime controller method");
		return state;
	}

	// to store the hotel details at a time
	@PostMapping(value = "/hotelDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StateDTO saveHotelDetails(@RequestBody StateDTO stateDTO) {
		System.out.println(stateDTO);
		return toursandTravelsService.saveHotelDetails(stateDTO);
	}

	@Autowired
	StateRepository stateRepository;

	// to get the Hotel Details by StateName
	@GetMapping("/getHotels/{stateName}")
	public StateDTO getHotelDetails(@PathVariable String stateName) {
		return toursandTravelsService.getHotelDetails(stateName);
	}

	// to save the ContactUs from Data
	@PostMapping("/saveContactUsData")
	public ResponseEntity<ContactUs> StoreContactUsData(@RequestBody ContactUsDTO contactUsDTO) {
		return toursandTravelsService.StoreContactUsData(contactUsDTO);
	}

	// to get the contactUs form Data
	@GetMapping("/getContactUsData")
	public List<ContactUsDTO> getContactUsDetails() {
		return toursandTravelsService.getContactUsDetails();
	}

	// to store hotelBooking Data
	@PostMapping("/BookHotel")
	public ResponseEntity<HotelBookingDTO> bookHotel(@RequestBody @Valid HotelBookingDTO hotelBookingDTO) {
		return toursandTravelsService.bookHotel(hotelBookingDTO);
	}
	
	//to get the hotelBooking Data
	@GetMapping("/GetHotelBookingsData")
	public ResponseEntity<List<HotelBookingDTO>> getHotelBookingDetails()
	{
		return toursandTravelsService.getHotelBookingDetails();
	}
	
	//to store the Transportation form Data
	
	

}
