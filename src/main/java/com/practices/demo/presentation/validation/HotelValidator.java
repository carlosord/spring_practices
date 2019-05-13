package com.practices.demo.presentation.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.HotelForm;
import com.practices.demo.service.utils.DateUtils;

/**
 * The Class HotelValidator.
 */
@Component
public class HotelValidator implements Validator {

	/**
	 * Supports.
	 *
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(HotelForm.class);
	}

	/**
	 * Validate.
	 *
	 * @param target the target
	 * @param errors the errors
	 */
	@Override
	public void validate(Object target, Errors errors) {

		HotelForm hotelForm = (HotelForm) target;

		if (!reserveStartDateIsValid(hotelForm.getStarthotelday() + "/" + hotelForm.getStarthotelmonth() + "/"
				+ hotelForm.getStarthotelyear())) {
			errors.rejectValue("starthotelday", "hotel.date.error.invalid");
			errors.rejectValue("starthotelmonth", "hotel.date.error.invalid");
			errors.rejectValue("starthotelyear", "hotel.date.error.invalid");

		}

		if (!reserveFinishDateIsValid(
				hotelForm.getStarthotelday() + "/" + hotelForm.getStarthotelmonth() + "/"
						+ hotelForm.getStarthotelyear(),
				hotelForm.getFinishhotelday() + "/" + hotelForm.getFinishhotelmonth() + "/"
						+ hotelForm.getFinishhotelyear())) {
			errors.rejectValue("finishhotelday", "hotel.date.error.invalid");
			errors.rejectValue("finishhotelmonth", "hotel.date.error.invalid");
			errors.rejectValue("finishhotelyear", "hotel.date.error.invalid");

		}

	}

	/**
	 * Reserve date is valid.
	 *
	 * @param startDate the start date
	 * @return true, if successful
	 */
	public boolean reserveStartDateIsValid(String startDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateToday = LocalDate.now();

		try {

			LocalDate startdate = LocalDate.parse(startDate, format);

			if (startdate.isBefore(dateToday)) {
				return false;
			} else {
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	/**
	 * Reserve finish date is valid.
	 *
	 * @param startDate  the start date
	 * @param finishDate the finish date
	 * @return true, if successful
	 */
	public boolean reserveFinishDateIsValid(String startDate, String finishDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {

			LocalDate dateStart = LocalDate.parse(startDate, format);

			LocalDate dateFinish = LocalDate.parse(finishDate, format);

			if (dateFinish.isBefore(dateStart) || dateFinish.equals(dateStart)) {
				return false;
			} else {
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

}
