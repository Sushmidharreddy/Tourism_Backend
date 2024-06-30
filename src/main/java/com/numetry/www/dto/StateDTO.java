package com.numetry.www.dto;



import java.util.List;

import lombok.Data;

@Data
public class StateDTO 
{
	private long stateId;

	private String stateName;
	
	private List<CategoryDTO> categories;
	
//	private Set<PlaceDTO> places;
	
	 private List<CityDTO> cities;
	 
	 @Override
	    public String toString() {
	        return "StateDTO{" +
	                "stateId=" + stateId +
	                ", stateName='" + stateName + '\'' +
	                // Do not include cities to avoid recursion
	                '}';
	    }
}
