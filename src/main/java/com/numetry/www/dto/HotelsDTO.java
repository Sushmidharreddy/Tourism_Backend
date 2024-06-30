package com.numetry.www.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class HotelsDTO 
{
	  private long id;
	private String hotelName;
	
	private String hotelImage;
	
	private String hotelAddress;
	
//	private HotelRating hotelRating;
	
	private List<PriceDTO> prices;
	
    @JsonBackReference
    private HotelRatingDTO hotelRating;
    
    @Override
    public String toString() {
        return "HotelsDTO{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelImage='" + hotelImage + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                // Do not include hotelRating to avoid recursion
                '}';
    }
    
    
}
