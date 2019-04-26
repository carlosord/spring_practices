package com.practices.demo.presentation;

import javax.validation.Valid;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.bussines.PersonServiceIpl;
import com.practices.demo.model.Gender;
import com.practices.demo.model.Persona;
import com.practices.demo.validations.forms.PersonForm;



public class SimpleControllerTest {

	@Test
	public void testRegisterUserIsOk() {

		PersonServiceIpl serv;

		SimpleController simpleController = new SimpleController();


		PersonForm personForm= new PersonForm();
		personForm.setDni("60449711F");
		personForm.setName("Juan");
		personForm.setLastname("Garcia");
		personForm.setDay("05");
		personForm.setMonth("10");
		personForm.setYear("1986");
		personForm.setGender(Gender.MALE);
		personForm.setHascar(true);


		DataBinder dbinder = new DataBinder(getClass());


		BindingResult bindingResult = dbinder.getBindingResult();

		String resultado  = null;
		try {
			resultado = simpleController.registerUser(personForm, bindingResult, null);
		} catch (Exception e) {
			Assert.assertNull(e.getMessage(), resultado);
		}

		Assert.assertFalse(bindingResult.hasErrors());
		//bindingResult.rejectValue("dni", "error.dni.duplicated");

	}

}