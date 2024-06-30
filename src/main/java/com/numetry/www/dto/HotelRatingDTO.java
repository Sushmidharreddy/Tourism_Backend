package com.numetry.www.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.numetry.www.entity.Hotels;

import lombok.Data;

@Data
public class HotelRatingDTO 
{
	private long id;
	private String hotelRating;

	 @JsonManagedReference
	private List<HotelsDTO> hotels;
	
	@JsonBackReference
	  private CityDTO city;
	
	public String toString()
	{
		return "HotelRatingDTO{" +
                "id=" + id +
                ", hotelRating='" + hotelRating + '\'' +
                // Do not include hotelRating to avoid recursion
                '}';
    }
}
	 
