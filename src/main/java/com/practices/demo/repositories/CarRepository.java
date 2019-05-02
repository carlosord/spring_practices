package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Car;

/**
 * The repository of car
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	Car findByLicense (String license);
}