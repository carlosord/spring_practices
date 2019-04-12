package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.business.PersonServices;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.validations.ValidacionDate;
import com.practices.demo.validations.ValidacionDni;

/**
 * Esta clase se enarga de interceptar las solicitudes entranes, convertir la carga útil de la solicitud a la estructura interna de los datos,
 * enviar los datos al modelo para su posterior procesamiento y avanzar esos datos a la visa para renderizar.
 *
 * @author Daniel.perez
 *
 *@see PersonServices
 *@see ValidacionDni
 *@see ValidacionDate
 *@see PersonServices
 */
@Controller
public class SimpleController {

	@Autowired
	private PersonServices serv;

	@Autowired
	private ValidacionDni validator;

	@Autowired
	private ValidacionDate validaFecha;

	/**
	 * Este método se encarga de cargar la página principal mostrando los atributos en ella.
	 * @param model esta varaible se encarga de cargar la página.
	 * @return Retorna a la página "/home"
	 *
	 * @see PersonServices
	 * @see Model
	 */
	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("personas", serv.findAll());
		return "home";
	}

	/**
	 * Este método se encarga de registrar/insertar las personas en el formulario.
	 * @param model esta varaible se encarga de cargar la página.
	 * @return Retorna a la página "register"
	 *
	 * @see PersonForm
	 * @see Model
	 */
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "register";
	}

	/**
	 * Este método sirve para añadir una persona y en el se encuentran los validadores
	 * @param personForm variable que llama al objeto {@code PersonForm}
	 * @param model esta varaible se encarga de cargar la página.
	 * @return Retorna a la página "register" si hay algun error y redirecciona a "home" en caso de que no tenga ningun error.
	 *
	 * @see Exception
	 * @see PersonForm
	 *
	 */
	@PostMapping("/create")
	public String submit(@Valid PersonForm personForm, BindingResult bindingResult, ModelMap model) {

		validator.validate(personForm, bindingResult);
		validaFecha.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "register";
		}

		try {
			serv.create(personForm.toPerson());
			return "redirect:/home";

		} catch (Exception e) {
			bindingResult.rejectValue("dni", "error.dni.duplicated");
			return "register";
		}
	}

	/**
	 * Este método sirve para buscar al usuario/persona por id.
	 * @param id variable que usa para localilzar a la persona por su Id
	 * @param model esta varaible se encarga de cargar la página.
	 * @return sirve para retornar a "update" y actualizar el usuario/persona
	 *
	 * @see PersonForm
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {

		PersonDto p = serv.findById(id);

		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(p);
		model.addAttribute("personForm", personForm);
		return "/update";
	}

	/**
	 * Este método sirve para insertar el usuario actualziado.
	 * @param personForm variable que llama al objeto {@code PersonForm}
	 * @param model esta varaible se encarga de cargar la página.
	 * @return Retornara a "home" en caso de que se haya modificado correctamente sino retorna a "update" de nuevo.
	 */
	@PostMapping("/update")
	public String updatePerson(@Valid PersonForm personForm, BindingResult bindingResult, ModelMap model)  {
		validator.validate(personForm, bindingResult);
		validaFecha.validate(personForm, bindingResult);

		if(bindingResult.hasErrors()) {
			return "update";
		}

		serv.updatePerson(personForm.toPerson());
		return "redirect:/home";
	}

	/**
	 * Este método sirve para borrar una persona/usuario.
	 * @param id variable que usa para localilzar a la persona por su Id.
	 * @param model esta varaible se encarga de cargar la página.
	 * @return te redirecciona a "home"
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, ModelMap model) {
		serv.delete(id);
		return "redirect:/home";
	}

}
