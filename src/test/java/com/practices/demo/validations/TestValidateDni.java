package com.practices.demo.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.validations.forms.PersonForm;

public class TestValidateDni {

	@Test
	public void positiveDniValidation() {

		ValidateDni v = new ValidateDni();

		PersonForm personForm = new PersonForm();
		personForm.setDni("53520672V");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertFalse("Dni error", errors.hasFieldErrors("dni"));

	}

	@Test
	public void negativeDniValidation() {

		ValidateDni v = new ValidateDni();

		PersonForm personForm = new PersonForm();
		personForm.setDni("53520672J");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Dni error", errors.hasFieldErrors("dni"));

	}

	@Test
	public void lenghtDniValidation() {

		ValidateDni v = new ValidateDni();

		PersonForm personForm = new PersonForm();
		personForm.setDni("535654763525727J");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Dni error", errors.hasFieldErrors("dni"));

	}

	@Test
	public void noletterDniValidation() {

		ValidateDni v = new ValidateDni();

		PersonForm personForm = new PersonForm();
		personForm.setDni("535206727");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Dni error", errors.hasFieldErrors("dni"));

	}



	@Test
	public void letternolastplaceDniValidation() {

		ValidateDni v = new ValidateDni();

		PersonForm personForm = new PersonForm();
		personForm.setDni("5352067V2");

		BindingResult errors = new DataBinder(personForm).getBindingResult();

		v.validate(personForm, errors);

		assertTrue("Dni error", errors.hasFieldErrors("dni"));

	}

}
