package com.practices.demo.presentation.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.repositories.PersonRepository;

/**
 * The Class PersonValidation.
 */
@Component
public class PersonValidator implements Validator {
	
	/** The Constant LETTERS. */
	private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(PersonForm.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		
		PersonForm personForm = (PersonForm) target;

		if (!dniIsValid(personForm.getDni())) {
			errors.rejectValue("dni", "person.dni.error.invalid");
		}

		if (personForm.getId() == null && dniIsDuplicate(personForm.getDni())) {
			errors.rejectValue("dni", "person.dni.error.duplicate");
		}
		
	}

	/**
	 * Dni is valid.
	 *
	 * @param dni the dni
	 * @return true, if successful
	 */
	private boolean dniIsValid(String dni) {
		
		Boolean check = false;
		
		if (dni.length() == 9) {
			for (int i = 0; i < dni.length() - 1; i++) {
				check = Character.isDigit(dni.charAt(i));
			}

			if(check) {
				Integer valor = new Integer(dni.substring(0, 8));
				int letraPos = valor % 23;
				
				check = dni.charAt(8) == LETTERS.charAt(letraPos);
			}
		}
		return check;
		
	}

	/**
	 * Dni is duplicate.
	 *
	 * @param dni the dni
	 * @return true, if successful
	 */
	private boolean dniIsDuplicate(String dni) {
		return personRepository.findByDni(dni) != null;
	}
	
}
