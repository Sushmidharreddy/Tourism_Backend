package com.numetry.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.www.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
