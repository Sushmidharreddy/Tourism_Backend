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
@JsonIgnoreProperties({"city"})
@EqualsAndHashCode(exclude = {"city", "hotels"})
public class HotelRating 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String hotelRating;
	
	
	@ManyToOne
	@JoinColumn(name="city_id")
	@JsonBackReference
	private City city;
	
	@OneToMany(mappedBy = "hotelRating")
	@JsonManagedReference
	private List<Hotels> hotels;
	
	
	
}
