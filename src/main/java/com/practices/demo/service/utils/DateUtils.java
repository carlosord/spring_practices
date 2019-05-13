package com.practices.demo.service.utils;

import java.util.Date;

import com.practices.demo.service.exception.BusinessException;


public class DateUtils {

	public static boolean between(Date startDto, Date finishDto, Date check) throws BusinessException {
		return check.after(startDto) && check.before(finishDto);
	}

	public static boolean range(Date startDto, Date finishDto, Date checkStart, Date checkFinish)
			throws BusinessException {
		return checkStart.before(startDto) && checkFinish.after(finishDto);
	}

	public static void checkDate(Date start, Date startDto, Date finish, Date finishDto) throws BusinessException {

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

}
