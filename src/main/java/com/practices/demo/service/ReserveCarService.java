package com.practices.demo.service;

import java.util.List;

import com.practices.demo.dto.CarReserveDto;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Interface ReserveCarService.
 */
public interface ReserveCarService {

	/**
	 * Add car to Person.
	 *
	 * @param id the id
	 */
	public boolean addCar(CarReserveDto car) throws BusinessException;

	public List<CarReserveDto> findCarReserveByPerson(PersonDto p);

}
