 package com.numetry.www.entity;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

 @Entity
 @Table
 @Data
 public class Transport 
 {
 	@Id
 	@GeneratedValue(strategy =GenerationType.IDENTITY )
 	private long id;
	
 	private String name;
 }
