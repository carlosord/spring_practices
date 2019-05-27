package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Hotel;

/**
 * The repository of Hotel.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	/**
	 * Find by code.
	 *
	 * @param code the code
	 * @return the hotel
	 */
	Hotel findByCode(String code);

}
