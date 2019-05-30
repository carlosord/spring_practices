package com.practices.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Car;
import com.practices.demo.model.ReserveCar;

/**
 * The Interface ReserveCarRepository.
 */
@Repository
public interface ReserveCarRepository extends JpaRepository<ReserveCar, Long> {

	/**
	 * Find reserve by car.
	 *
	 * @param c the c
	 * @return the list
	 */
	List<ReserveCar> findReserveByCar(Car c);

	/**
	 * Find by person dni.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	List<ReserveCar> findByPersonDni(String dni);

	/**
	 * Find by period.
	 *
	 * @param start  the start
	 * @param finish the finish
	 * @return the list
	 */
	@Query(value = "FROM ReserveCar WHERE START_RESERVE BETWEEN :startDate AND :finishDate")
	List<ReserveCar> findByPeriod(@Param("startDate") Date start, @Param("finishDate") Date finish);

}
