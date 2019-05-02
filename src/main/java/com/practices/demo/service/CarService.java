package com.practices.demo.service;

import java.util.List;

import com.practices.demo.dto.CarDto;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Class PersonService.
 */
public interface CarService {

	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the car dto
	 */
	public CarDto findCarById(Long id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<CarDto> findAll();

	/**
	 * Find person by license.
	 *
	 * @param license the license
	 * @return the car dto
	 */
	public CarDto findByLicense(String license);

	/**
	 * Adds the new car.
	 *
	 * @param car the car
	 * @return the car dto
	 * @throws BusinessException
	 */
	public CarDto addNewCar (CarDto car) throws BusinessException;

}
