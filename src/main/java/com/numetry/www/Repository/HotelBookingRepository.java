package com.numetry.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.www.entity.HotelBooking;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long>
{
	
}
