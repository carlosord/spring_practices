package com.practices.demo.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.validations.forms.PersonForm;

@Component
public class ValidarFecha implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(PersonForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		PersonForm p = (PersonForm) target;

		if (!validarFecha(p.getFechanac()))
			errors.rejectValue("fechanac", "error.fecha.invalid");

	}

	public boolean validarFecha(String fechanac) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {

			format.setLenient(false);
			format.parse(fechanac);
		} catch (ParseException e) {
			return false;
		}catch(IllegalArgumentException e) {
			return false;
		}

		return true;

	}

}
