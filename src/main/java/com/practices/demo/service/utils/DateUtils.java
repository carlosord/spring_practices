package com.practices.demo.service.utils;

import java.util.Date;

import com.practices.demo.service.exception.BusinessException;

/**
 * The Class DateUtils.
 */
public class DateUtils {

	/**
	 * Between.
	 *
	 * @param startDto  the start dto
	 * @param finishDto the finish dto
	 * @param check     the check
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	public static boolean between(Date startDto, Date finishDto, Date check) throws BusinessException {
		return check.after(startDto) && check.before(finishDto);
	}

	/**
	 * Range.
	 *
	 * @param startDto    the start dto
	 * @param finishDto   the finish dto
	 * @param checkStart  the check start
	 * @param checkFinish the check finish
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */

	public static boolean range(Date startDto, Date finishDto, Date checkStart, Date checkFinish)
			throws BusinessException {
		return checkStart.before(startDto) && checkFinish.after(finishDto);
	}

	/**
	 * Check date car.
	 *
	 * @param start     the start
	 * @param startDto  the start dto
	 * @param finish    the finish
	 * @param finishDto the finish dto
	 * @throws BusinessException the business exception
	 */
	public static void checkDateCar(Date start, Date startDto, Date finish, Date finishDto) throws BusinessException {

		if (start.compareTo(startDto) == 0 || between(start, finish, startDto)) {
			throw new BusinessException("car.date.error", "startreserveday");
		}

		if (finish.compareTo(finishDto) == 0 || between(start, finish, finishDto)) {
			throw new BusinessException("car.date.error", "finishreserveday");
		}

		if (range(start, finish, startDto, finishDto)) {
			throw new BusinessException("car.date.error", "startreserveday");
		}
	}

	/**
	 * Check date hotel.
	 *
	 * @param start     the start
	 * @param startDto  the start dto
	 * @param finish    the finish
	 * @param finishDto the finish dto
	 * @throws BusinessException the business exception
	 */
	public static void checkDateHotel(Date start, Date startDto, Date finish, Date finishDto) throws BusinessException {

		if (start.compareTo(startDto) == 0 || between(start, finish, startDto)) {
			throw new BusinessException("hotel.date.error.invalid", "starthotelday");
		}

		if (finish.compareTo(finishDto) == 0 || between(start, finish, finishDto)) {
			throw new BusinessException("hotel.date.error.invalid", "finishhotelday");
		}

		if (range(start, finish, startDto, finishDto)) {
			throw new BusinessException("hotel.date.error.invalid", "starthotelday");
		}
	}

}
