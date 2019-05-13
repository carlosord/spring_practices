package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.presentation.form.HotelForm;
import com.practices.demo.presentation.form.CarForm;
import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.front.View;
import com.practices.demo.presentation.validation.PersonValidator;
import com.practices.demo.presentation.validation.ReserveCarDateValidator;
import com.practices.demo.service.HotelService;
import com.practices.demo.service.CarService;
import com.practices.demo.service.PersonService;
import com.practices.demo.service.ReserveCarService;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Class PersonController.
 */
@Controller
public class PersonController {

	/** The person service. */
	@Autowired
	private PersonService personService;

	/** The hotel service. */
	@Autowired
	private HotelService hotelService;

	/** The person validator. */
	@Autowired
	private PersonValidator personValidator;

	/** The reserve car validator. */
	@Autowired
	private ReserveCarDateValidator reserveCarValidator;

	/** The car service. */
	@Autowired
	private CarService carService;

	/** The reserve car service. */
	@Autowired
	private ReserveCarService reserveCarService;

	/**
	 * Show all.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.HOME_URL)
	public String showAll(ModelMap model) {

		// Add all people to model
		model.addAttribute("people", personService.findAll());

		// Return home view
		return View.HOME_VIEW;

	}

	/**
	 * Show new person form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.NEW_PERSON_URL)
	public String showNewPersonForm(ModelMap model) {

		// Add new person to model
		model.addAttribute("personForm", new PersonForm());

		// Return new person view
		return View.NEW_PERSON_VIEW;

	}

	/**
	 * Adds the new person.
	 *
	 * @param model         the model
	 * @param personForm    the person form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.NEW_PERSON_URL)
	public String addNewPerson(ModelMap model, @Valid PersonForm personForm, BindingResult bindingResult) {

		// Validate person form
		personValidator.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return View.NEW_PERSON_VIEW;
		}

		try {

			// Add new person to db
			personService.addNewPerson(personForm.toPerson());

			// Return new person view
			return View.redirect(View.HOME_VIEW);

		} catch (BusinessException b) {

			bindingResult.rejectValue(b.getField(), b.getMessage());

			// Go back form
			return View.NEW_PERSON_VIEW;
		}

	}

	/**
	 * Show new person form.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.EDIT_PERSON_URL + "/{id}")
	public String showEditPersonForm(@PathVariable("id") Long id, ModelMap model) {

		// Get the person
		PersonDto person = personService.findPersonById(id);

		// Put data from dto to form
		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(person);

		// Add new person to model
		model.addAttribute("personForm", personForm);

		// Return new person view
		return View.EDIT_PERSON_VIEW;

	}

	/**
	 * Update person.
	 *
	 * @param model         the model
	 * @param personForm    the person form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.EDIT_PERSON_URL)
	public String updatePerson(ModelMap model, @Valid PersonForm personForm, BindingResult bindingResult) {

		// Validate person form
		personValidator.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return View.NEW_PERSON_VIEW;
		}

		// Add new person to db
		personService.updatePerson(personForm.toPerson());

		// Return home view
		return View.redirect(View.HOME_VIEW);

	}

	/**
	 * Delete person form.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.DELETE_PERSON_URL + "/{id}")
	public String deletePersonForm(@PathVariable("id") Long id, ModelMap model) {

		// Delete the person
		personService.deletePersonForm(id);

		// Return home view
		return View.redirect(View.HOME_VIEW);

	}

	/**
	 * Adds the new reserve.
	 *
	 * @param model         the model
	 * @param hotelForm     the hotel form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.HOTEL_URL)
	public String addNewReserve(ModelMap model, @Valid HotelForm hotelForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return View.HOTEL_VIEW;
		}

		try {

			// Add new reserve to db
			personService.addNewReserve(hotelForm.toHotel());

			// Return new reserve view
			return View.redirect(View.HOME_VIEW);

		} catch (BusinessException b) {

			// TODO: Revisar
			model.addAttribute("allHotels", hotelService.findAll());
			bindingResult.rejectValue(b.getField(), b.getMessage());

			// Go back form
			// return View.redirect(View.HOTEL_VIEW + "/" + hotelForm.getDni());
			return View.HOTEL_VIEW;
		}

	}

	/**
	 * Adds the car.
	 *
	 * @param model         the model
	 * @param carForm       the car form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.CAR_URL)
	public String addCar(ModelMap model, @Valid CarForm carForm, BindingResult bindingResult) {

		reserveCarValidator.validate(carForm, bindingResult);

		if (bindingResult.hasErrors()) {

			model.addAttribute("allCars", carService.findAll());
			return View.CAR_VIEW;
		}

		try {
			reserveCarService.addCar(carForm.toCar());

			return View.redirect(View.HOME_VIEW);

		} catch (BusinessException b) {

			model.addAttribute("allCars", carService.findAll());
			bindingResult.rejectValue(b.getField(), b.getMessage());

			return View.CAR_VIEW;

		}
	}

}
