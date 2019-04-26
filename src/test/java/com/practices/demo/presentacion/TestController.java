package com.practices.demo.presentacion;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.model.Gender;
import com.practices.demo.presentation.SimpleController;
import com.practices.demo.presentation.form.PersonForm;

public class TestController {

	@Test
	public void testRegisterUserOk() {
		SimpleController sc = new SimpleController();

		PersonForm p = new PersonForm();

		p.setDni("35475031S");
		p.setName("Paco");
		p.setLastname("Perez");
		p.setGender(Gender.MALE);
		p.setDay("01");
		p.setMonth("05");
		p.setYear("2000");
		p.setHascar(true);

		DataBinder db = new DataBinder(getClass());

		BindingResult b = db.getBindingResult();

		String resultado = null;
		try{
		resultado = sc.submit(p, b, null);

		}catch(Exception e) {
			Assert.assertNull(e.getMessage(),resultado);
		}

		Assert.assertFalse(b.hasErrors());




	}

}
