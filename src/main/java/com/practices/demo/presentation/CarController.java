package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practices.demo.presentation.form.CarForm;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.front.View;
import com.practices.demo.service.CarService;

/**
 * The Class CarController.
 */
@Controller
public class CarController {

	/** The car service. */
	@Autowired
	private CarService carService;

	/**
	 * Show all.
	 *
	 * @param dni   the dni
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.CAR_URL + "/{dni}")
	public String showAll(@PathVariable("dni") String dni, ModelMap model) {
		model.addAttribute("allCars", carService.findAll());
		model.addAttribute("carForm", new CarForm());

		CarForm carForm = new CarForm();
		carForm.setDni(dni);

		model.addAttribute("carForm", carForm);

		return View.CAR_VIEW;
	}

}
