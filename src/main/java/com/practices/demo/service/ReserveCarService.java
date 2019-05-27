package com.practices.demo.service;

import java.util.List;

import com.practices.demo.dto.CarReserveDto;
import com.practices.demo.dto.ListCarDto;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Interface ReserveCarService.
 */
public interface ReserveCarService {

	/**
	 * Add car to Person.
	 *
	 * @param car the car
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	public boolean addCar(CarReserveDto car) throws BusinessException;

	/**
	 * Find car reserve by person dni.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	public List<ListCarDto> findCarReserveByPersonDni(String dni);

}
