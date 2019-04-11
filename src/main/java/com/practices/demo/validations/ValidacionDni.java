package com.practices.demo.validations;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.presentation.form.PersonForm;

@Component
public class ValidacionDni implements Validator{

	@Autowired
	private PersonaRepository repo;

	public boolean supports(Class clazz) {
		return clazz.equals(PersonForm.class);
	}

	public void validate(Object target, Errors errors) {

		PersonForm p = (PersonForm) target;

		if (!validarDni(p.getDni()))
			errors.rejectValue("dni", "error.dni.invalid");
	}


	public boolean validarDni(String dni){
        boolean correcto=false;
        Pattern pattern=Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKE])");
        Matcher matcher=pattern.matcher(dni);
        if(matcher.matches()){
            String letra=matcher.group(2);
            String letras="TRWAGMYFPDXBNJZSQVHLCKE";
            int index=Integer.parseInt(matcher.group(1));
            index=index%23;
            String reference=letras.substring(index,index+1);
            if(reference.equals(letra)){
                correcto=true;
            }else{
                correcto=false;
            }
        }else{
            correcto=false;
        }
        return correcto;
    }

	public boolean dniDuplicado(String dni) {

		return repo.findByDni(dni) != null;

	}
}
