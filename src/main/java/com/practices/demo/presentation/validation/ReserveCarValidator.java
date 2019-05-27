package com.practices.demo.presentation.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.CarForm;

/**
 * The Class ReserveCarValidator.
 */
@Component
public class ReserveCarValidator implements Validator {

	/**
	 * Supports.
	 *
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CarForm.class);
	}

	/**
	 * Validate.
	 *
	 * @param target the target
	 * @param errors the errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		CarForm carForm = (CarForm) target;

		if (!reserveStartDateIsValid(carForm.getStartreserveday() + "/" + carForm.getStartreservemonth() + "/"
				+ carForm.getStartreserveyear())) {
			errors.rejectValue("startreserveday", "car.startdate.error.invalid");

		}

		if (!reserveFinishDateAfterStartDate(
				carForm.getStartreserveday() + "/" + carForm.getStartreservemonth() + "/"
						+ carForm.getStartreserveyear(),
				carForm.getFinishreserveday() + "/" + carForm.getFinishreservemonth() + "/"
						+ carForm.getFinishreserveyear())) {
			errors.rejectValue("finishreserveday", "car.finishdate.error.invalid");

		}

	}

	/**
	 * Reserve start date is valid.
	 *
	 * @param reservedate the reservedate
	 * @return true, if successful
	 */
	public boolean reserveStartDateIsValid(String reservedate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();

		try {

			LocalDate startdate = LocalDate.parse(reservedate, format);

			if (startdate.isBefore(localDate)) {
				return false;
			} else {
				return true;
			}

		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	/**
	 * Reserve finish date after start date.
	 *
	 * @param startReserveDate  the start reserve date
	 * @param finishReserveDate the finish reserve date
	 * @return true, if successful
	 */
	public boolean reserveFinishDateAfterStartDate(String startReserveDate, String finishReserveDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {

			LocalDate dateStart = LocalDate.parse(startReserveDate, format);
			LocalDate dateFinish = LocalDate.parse(finishReserveDate, format);

			if (dateFinish.isBefore(dateStart) || dateFinish.isEqual(dateStart)) {
				return false;
			} else {
				return true;
			}

		} catch (IllegalArgumentException e) {
			return false;
		}

	}

}
