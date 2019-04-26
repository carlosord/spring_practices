package com.practices.demo.validation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.validations.ValidacionDni;

public class TestValidateDni {

	@Test
    public void positiveDniValidation() {

        ValidacionDni v = new ValidacionDni();

        PersonForm personForm = new PersonForm();
        personForm.setDni("53520672V");

        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertFalse("Dni error", errors.hasFieldErrors("dni"));
    }

	@Test
	public void negativeDniValidation() {

		ValidacionDni v = new ValidacionDni();

        PersonForm personForm = new PersonForm();
        personForm.setDni("53520672Z");

        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Dni error", errors.hasFieldErrors("dni"));
	}

	@Test
	public void lenghtDniValidation() {

		ValidacionDni v = new ValidacionDni();

        PersonForm personForm = new PersonForm();
        personForm.setDni("53520672453V");

        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Dni error", errors.hasFieldErrors("dni"));
	}

	@Test
	public void noLetterDniValidation() {

		ValidacionDni v = new ValidacionDni();

        PersonForm personForm = new PersonForm();
        personForm.setDni("53520672");

        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Dni error", errors.hasFieldErrors("dni"));
	}

	@Test
	public void letterNoCorrectPlaceDniValidation() {

		ValidacionDni v = new ValidacionDni();

        PersonForm personForm = new PersonForm();
        personForm.setDni("535Z20672");

        BindingResult errors = new DataBinder(personForm).getBindingResult();

        v.validate(personForm, errors);

        assertTrue("Dni error", errors.hasFieldErrors("dni"));
	}

}
