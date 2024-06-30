package com.numetry.www.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Price 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	 private String roomType;
	 private String price;

	 @ManyToOne
	 @JoinColumn(name = "hotel_id", nullable = false)
	 @JsonBackReference
	 private Hotels hotel;
}
