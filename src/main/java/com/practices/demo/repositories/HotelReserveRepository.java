package com.practices.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	/**
	 * Find by period.
	 *
	 * @param start  the start
	 * @param finish the finish
	 * @return the list
	 */
	@Query(value = "FROM ReserveHotel WHERE START_RESERVE BETWEEN :startDate AND :finishDate")
	List<ReserveHotel> findByPeriod(@Param("startDate") Date start, @Param("finishDate") Date finish);
}
