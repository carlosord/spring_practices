package com.practices.demo.service;

import java.util.Date;
import java.util.List;

import com.practices.demo.dto.DetailsReserveHotelDto;
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

	/**
	 * Find hotel reserve by period.
	 *
	 * @param start  the start
	 * @param finish the finish
	 * @return the list
	 */
	public List<DetailsReserveHotelDto> findHotelReserveByPeriod(Date start, Date finish);

	/**
	 * Find hotel reserve tomorrow.
	 *
	 * @return the list
	 */
	public List<DetailsReserveHotelDto> findHotelReserveTomorrow();

	/**
	 * Find hotel reserve last week.
	 *
	 * @return the list
	 */
	public List<DetailsReserveHotelDto> findHotelReserveLastWeek();

	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the details reserve hotel dto
	 */
	public DetailsReserveHotelDto findPersonById(Long id);

}
