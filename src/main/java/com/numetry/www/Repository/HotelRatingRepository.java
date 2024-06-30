package com.numetry.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.www.entity.HotelRating;

public interface HotelRatingRepository extends JpaRepository<HotelRating, Long> {

}
