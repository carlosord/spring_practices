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

	public List<ListHotelDto> findHotelReserveByPersonDni(String dni);

}
