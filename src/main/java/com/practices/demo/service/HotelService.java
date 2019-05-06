package com.practices.demo.service;

import java.util.List;

import com.practices.demo.dto.HotelDto;

/**
 * The Class HotelService.
 */
public interface HotelService {

	/**
	 * Find hotel by id.
	 *
	 * @param id the id
	 * @return the hotel dto
	 */
	public HotelDto findHotelById(Long id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<HotelDto> findAll();

	/**
	 * Find hotel by code.
	 *
	 * @param code the code
	 * @return the hotel dto
	 */
	public HotelDto findHotelByCode(String code);

	/**
	 * Adds the new reserve.
	 *
	 * @param hotel the hotel
	 * @return the hotel dto
	 * @throws BusinessException
	 */

}
