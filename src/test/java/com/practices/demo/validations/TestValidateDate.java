package com.practices.demo.validations;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.validations.forms.PersonForm;

public class TestValidateDate {

	@Test
	public void correctDateValidation() {

		ValidarFecha v = new ValidarFecha();

		PersonForm personForm = new PersonForm();
		personForm.setDay("20");
		personForm.setMonth("10");
		personForm.setYear("1995");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertFalse("Day error", errors.hasFieldErrors("day"));
		assertFalse("Month error", errors.hasFieldErrors("month"));
		assertFalse("Year error", errors.hasFieldErrors("year"));


	}


	@Test
	public void incorrectDayDateValidation() {

		ValidarFecha v = new ValidarFecha();

		PersonForm personForm = new PersonForm();
		personForm.setDay("4000");
		personForm.setMonth("10");
		personForm.setYear("1995");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Day error", errors.hasFieldErrors("day"));
		assertTrue("Month error", errors.hasFieldErrors("month"));
		assertTrue("Year error", errors.hasFieldErrors("year"));


	}


	@Test
	public void incorrectMonthDateValidation() {

		ValidarFecha v = new ValidarFecha();

		PersonForm personForm = new PersonForm();
		personForm.setDay("20");
		personForm.setMonth("3000");
		personForm.setYear("1995");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Day error", errors.hasFieldErrors("day"));
		assertTrue("Month error", errors.hasFieldErrors("month"));
		assertTrue("Year error", errors.hasFieldErrors("year"));


	}


	@Test
	public void incorrectYearDateValidation() {

		ValidarFecha v = new ValidarFecha();

		PersonForm personForm = new PersonForm();
		personForm.setDay("12");
		personForm.setMonth("10");
		personForm.setYear("2050");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Day error", errors.hasFieldErrors("day"));
		assertTrue("Month error", errors.hasFieldErrors("month"));
		assertTrue("Year error", errors.hasFieldErrors("year"));


	}

}
