package com.numetry.www.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class CityDTO 
{
	private long id;
	private String cityName;
	
	@JsonManagedReference
	private List<HotelRatingDTO> hotelRating;
	
	 @Override
	    public String toString() {
	        return "CityDTO{" +
	                "id=" + id +
	                ", cityName='" + cityName + '\'' +
	                // Do not include hotelRating to avoid recursion
	                '}';
	    }
}
