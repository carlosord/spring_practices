package com.practices.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveHotel;

/**
 * The Interface HotelReserveRepository.
 */
@Repository
public interface HotelReserveRepository extends JpaRepository<ReserveHotel, Long> {

	/**
	 * Find reserve by person.
	 *
	 * @param p the p
	 * @return the list
	 */
	List<ReserveHotel> findReserveByPerson(Person p);

}
