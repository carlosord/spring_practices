package com.practices.demo.validation;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.model.Persona;
import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.validations.ValidacionDate;

public class TestValidateDate {

	@Test
	public void correctTestDate() {

		ValidacionDate v = new ValidacionDate();

		PersonForm personForm = new PersonForm();
		personForm.setDay("10");
		personForm.setMonth("10");
		personForm.setYear("2010");


        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertFalse("Day error", errors.hasFieldErrors("day"));
        assertFalse("Month error", errors.hasFieldErrors("month"));
        assertFalse("Year error", errors.hasFieldErrors("year"));

	}

	@Test
	public void incorrectTestDate() {

		ValidacionDate v = new ValidacionDate();

		PersonForm personForm = new PersonForm();
		personForm.setDay("10000");
		personForm.setMonth("10");
		personForm.setYear("2");


        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Day error", errors.hasFieldErrors("day"));
        assertTrue("Month error", errors.hasFieldErrors("month"));
        assertTrue("Year error", errors.hasFieldErrors("year"));

	}

	@Test
	public void incorrectYearTestDate() {

		ValidacionDate v = new ValidacionDate();

		PersonForm personForm = new PersonForm();
		personForm.setDay("10");
		personForm.setMonth("10");
		personForm.setYear("2019000000");


        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Day error", errors.hasFieldErrors("day"));
        assertTrue("Month error", errors.hasFieldErrors("month"));
        assertTrue("Year error", errors.hasFieldErrors("year"));

	}
}
