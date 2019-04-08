package com.practices.demo.presentation.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.repositories.PersonRepository;

@Component("personValidator")
public class PersonValidation implements Validator {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(PersonForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PersonForm personForm = (PersonForm) target;

		if (!dniIsValid(personForm.getDni())) {
			errors.rejectValue("dni", "person.dni.error.invalid");
		}

		if (personForm.getId()==null && dniIsDuplicate(personForm.getDni())) {
			errors.rejectValue("dni", "person.dni.error.duplicate");
		}
	}

	private boolean dniIsValid(String dni) {
		final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Boolean check = false;
		
		if (dni.length() == 9) {
			for (int i = 0; i < dni.length() - 1; i++) {
				check = Character.isDigit(dni.charAt(i));
			}

			if(check) {
				Integer valor = new Integer(dni.substring(0, 8));
				int letraPos = valor % 23;
				
				check = dni.charAt(8) == letras.charAt(letraPos);
			}
		}
		return check;
	}

	private boolean dniIsDuplicate(String dni) {
		return personRepository.findByDni(dni) != null;
	}
}
