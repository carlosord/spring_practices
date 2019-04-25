package com.practices.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.presentation.validation.PersonValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

	@Test
	@Rollback
	public void positiveDniValidation() {
		
		PersonValidator v = new PersonValidator();
		
		PersonForm personForm = new PersonForm();
		personForm.setDni("53520672V");
		
		BindingResult errors = new DataBinder(personForm).getBindingResult();
		
		v.validate(personForm, errors);
		
		assertFalse("Dni error", errors.hasFieldErrors("dni"));
		
	}
	
	@Test
	@Rollback
	public void negativeDniValidation() {
		
		PersonValidator v = new PersonValidator();
		
		PersonForm personForm = new PersonForm();
		personForm.setDni("53520672F");
		
		BindingResult errors = new DataBinder(personForm).getBindingResult();
		
		v.validate(personForm, errors);
		assertTrue("Dni error", errors.hasFieldErrors("dni"));
		
	}

}
