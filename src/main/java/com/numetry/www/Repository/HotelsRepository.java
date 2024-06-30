package com.numetry.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.www.entity.Hotels;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {

}
