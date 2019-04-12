package com.practices.demo.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.validations.forms.PersonForm;

/**
 * Esta clase se encarga de validar la fecha
 * @author Jairo.Rodriguez
 *
 */

@Component
public class ValidarFecha implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(PersonForm.class);
	}

	/**
	 * Se encarga de comprobar que la fecha sea valida y sino muestra un mensaje de error
	 */

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		PersonForm p = (PersonForm) target;

		if (!validarFecha(p.getDay() + "/" + p.getMonth() + "/" + p.getYear())) {
			errors.rejectValue("day", "error.fecha.invalid");
			errors.rejectValue("month", "error.fecha.invalid");
			errors.rejectValue("year", "error.fecha.invalid");
		}
	}



	/**
	 * Este metodo se encarga de validar la fceha y su formato
	 * @param fechanac
	 *
	 *
	 * @return	retorna true si la validadcion es correcta y false si no lo es
	 */
	public boolean validarFecha(String fechanac) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		try {

			format.setLenient(false);
			format.parse(fechanac);
			return today.after(format.parse(fechanac));
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

}
