package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.validations.ValidarFecha;
import com.practices.demo.validations.ValidateDni;
import com.practices.demo.validations.forms.PersonForm;
import com.practices.demo.bussines.PersonServiceIpl;
import com.practices.demo.dto.PersonaDTO;

/** Esta clase se enarga de interceptar las solicitudes entranes, convertir la carga útil de la solicitud a la estructura interna de los datos,
* enviar los datos al modelo para su posterior procesamiento y avanzar esos datos a la visa para renderizar.
*/

@Controller
public class SimpleController {

	@Autowired
	private PersonServiceIpl serv;

	@Autowired
	ValidateDni validator;

	@Autowired
	ValidarFecha validatordate;

	/**
	 * Este metodo se encarga de cargar la pagina principal mostrando la informacion de los usuarios en ella
	 *
	 * @param model
	 *
	 * @return retorna a la pagina principal
	 */

	@GetMapping("/home")
	public String homePage(Model model) {

		model.addAttribute("personas", serv.findAll());
		return "home";
	}


	/**
	 * Este metodo se encarga de cargar la pagina de registro de usuarios
	 * @param model
	 * @return retorna a la pagina de registro
	 */
	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("personForm", new PersonForm());
		return "register";
	}


	/**
	 * Este metodo se encarga de que una vez validados los campos, se registre e inserte el usuario, y en el caso de que la validacion no sea correcta
	 * nos muestre un mensaje de error
	 *
	 * @param personForm
	 * @param bindingResult
	 * @param model
	 *
	 * @return retorna a la pagina principal si la validacion de los campos es correcta y registra al usuario, si la validacion de
	 * alguno de los campos no es correcta nos retorna a la pagina de registro
	 *
	 * @throws Exception
	 */
	@PostMapping("/create")
	public String registerUser(@Valid PersonForm personForm, BindingResult bindingResult, Model model)
			throws Exception {
		/**
		 * personForm lo transformas en un PersonDTO
		 *  PersonDTO es el que pasas al
		 * servicio
		 */

		validator.validate(personForm, bindingResult);
		validatordate.validate(personForm, bindingResult);


		if (bindingResult.hasErrors()) {
			// model.addAttribute("persona", createperson);
			return "register";
		}

		try {
			serv.registerUser(personForm.toPerson());
			return "redirect:/home";

		} catch (Exception e) {
			bindingResult.rejectValue("dni", "error.dni.duplicated");
			// model.addAttribute("persona", createperson);
			return "register";
		}



	}


	/**
	 * Este metodo se encarga de cargar la pagina de edicion de usuarios buscandolo por id
	 * @param model
	 * @return retorna a la pagina de edicion
	 */
	@GetMapping("/edit/{id}")
	public String edituser(@PathVariable("id") String id, Model model) {

		PersonaDTO p = serv.edituser(id);

		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(p);

		model.addAttribute("personForm", personForm);
		return "/update";

	}


	/**
	 * Este metodo se encarga de que una vez validados los campos, se modifique e inserte el usuario con los cambios
	 *
	 * @param personForm
	 * @param bindingResult
	 * @param model
	 *
	 * @return retorna a la pagina principal si la validacion de los campos es correcta, y modifica y registra al usuario, si la validacion de
	 * alguno de los campos no es correcta nos retorna a la pagina de edicion
	 *
	 * @throws Exception
	 */
	@PostMapping("/update")
	public String updatePerson(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		validator.validate(personForm, bindingResult);
		validatordate.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			// model.addAttribute("persona", createperson);
			return "update";
		}
		serv.updatePerson(personForm.toPerson());

		return "redirect:/home";
	}


	/**
	 * Este metodo se encarga de eliminar usuarios buscandolo por id
	 * @param model
	 * @return retorna a la pagina principal
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable long id, Model model) {

		serv.deleteUser(id);
		return "redirect:/home";
	}

}
