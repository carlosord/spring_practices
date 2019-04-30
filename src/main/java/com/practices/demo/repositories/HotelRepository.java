package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{
	
	@Query("SELECT h from Hotel h WHERE h.code=(:code)")
	Hotel findByCode(@Param("code")int code); 

}
