package com.numetry.www.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"state"}) 
@EqualsAndHashCode(exclude = {"state", "hotelRating"})
public class City
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cityName;
	
	
	@ManyToOne
	@JoinColumn(name="state_id")
	@JsonBackReference
	private State state;
	
	@OneToMany(mappedBy = "city")
	@JsonManagedReference
	private List<HotelRating> hotelRating;
	
	
	
	
}
