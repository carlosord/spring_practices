package com.practices.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.ReserveHotel;

/**
 * The Interface HotelReserveRepository.
 */
@Repository
public interface HotelReserveRepository extends JpaRepository<ReserveHotel, Long> {

	/**
	 * Find by person dni.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	List<ReserveHotel> findByPersonDni(String dni);
}
