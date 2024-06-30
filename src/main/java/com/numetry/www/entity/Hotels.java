package com.numetry.www.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(exclude = {"hotelRating", "pricing"})
public class Hotels 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String hotelName;
	
	
	private String hotelImage;
	
	private String hotelAddress;
	

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private List<Price> prices;
	
	@ManyToOne
	@JoinColumn(name="hotelRating_id")
	@JsonBackReference
	private HotelRating hotelRating;
	
	
	
	
	
}
