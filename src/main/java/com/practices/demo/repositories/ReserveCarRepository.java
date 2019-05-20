package com.practices.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Car;
import com.practices.demo.model.ReserveCar;

/**
 * The Interface ReserveCarRepository.
 */
@Repository
public interface ReserveCarRepository extends JpaRepository<ReserveCar, Long> {

	List<ReserveCar> findReserveByCar(Car c);

	List<ReserveCar> findByPersonDni(String dni);

}
