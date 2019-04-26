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


/**
 * Esta clase sirve para validar el DNI implementando a {@code Validator}
 * @author Daniel.perez
 *
 *@see Validator
 */
@Component
public class ValidacionDni implements Validator{

	public boolean supports(Class clazz) {
		return clazz.equals(PersonForm.class);
	}

	/**
	 * Se encarga de validar que el DNI sea valido. En caso de que lo sea mostrara un mensaje de error.
	 */
	public void validate(Object target, Errors errors) {

		PersonForm p = (PersonForm) target;

		if (!validarDni(p.getDni()))
			errors.rejectValue("dni", "error.dni.invalid");
	}

	/**
	 * Este método se encarga de validar el DNI que sea correcto coincidiendo los números con la letra.
	 * @param dni variable de tipo cadena que se le pasa el DNI
	 * @return Retorna "true" en caso de que la validación sea correcta y "false" si no lo es.
	 */
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
}
