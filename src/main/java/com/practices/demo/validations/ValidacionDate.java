package com.practices.demo.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.PersonForm;

@Component
public class ValidacionDate implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(PersonForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		PersonForm p = (PersonForm) target;


		if (!validarFecha(p.getFecha()))
			errors.rejectValue("fecha", "error.fecha.invalid");

	}

	public boolean validarFecha(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			format.setLenient(false);
			format.parse(fecha);
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;

	}
}
