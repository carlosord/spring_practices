package com.practices.demo.service;

import java.util.List;

import com.practices.demo.dto.ListHotelDto;
import com.practices.demo.dto.ReserveHotelDto;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Interface HotelReserveService.
 */
public interface HotelReserveService {

	/**
	 * Adds the new reserve.
	 *
	 * @param reservehotel the reservehotel
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	public boolean addNewReserve(ReserveHotelDto reservehotel) throws BusinessException;

	/**
	 * Find hotel reserve by person dni.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	public List<ListHotelDto> findHotelReserveByPersonDni(String dni);

}
