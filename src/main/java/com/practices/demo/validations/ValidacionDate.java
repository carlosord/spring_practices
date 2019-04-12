package com.practices.demo.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.PersonForm;


/**
 * Esta clase se encarga de validar la fecha implementando a {@code Validator}
 * @author Daniel.perez
 *
 * @see Validator
 *
 */
@Component
public class ValidacionDate implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(PersonForm.class);
	}

	/**
	 * Este método se encarga de validar la fecha del formulario, si no es válido mostrara los mensajes de error correspondientes.
	 */
	@Override
	public void validate(Object target, Errors errors) {

		PersonForm p = (PersonForm) target;

		if (!validarFecha(p.getDay() + "/" + p.getMonth() + "/" + p.getYear())) {
			errors.rejectValue("day", "error.fecha.invalid");
			errors.rejectValue("month", "error.fecha.invalid");
			errors.rejectValue("year", "error.fecha.invalid");
		}
	}

	/**
	 * Este método se encarga de validar el formato de la fecha y que la fecha nunca sea posterior a la fecha actual.
	 * @param fecha
	 * @return Retorna "true" en caso de que sea correcto y "false" si no lo es.
	 */
	public boolean validarFecha(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaToday = new Date();

		try {
			format.setLenient(false);
			format.parse(fecha);
			return fechaToday.after(format.parse(fecha));
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

}
