package com.numetry.www.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@Table
@EqualsAndHashCode(exclude = {"cities"})
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stateId;

    private String stateName;
    
    
    @OneToMany(mappedBy = "state")
    private List<Category> categories;
    
//    @OneToMany(mappedBy = "state")
//    private Set<Place> places;
    
    @OneToMany(mappedBy = "state")
    private List<City> cities;
    
}
