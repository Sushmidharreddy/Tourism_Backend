package com.numetry.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.www.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
