package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.practices.demo.presentation.front.View;
import com.practices.demo.service.CarService;

/**
 * The Class CarController.
 */
@Controller
public class CarController {

	/** The person repository. */
	@Autowired
	CarService carService;


	public String showAll(ModelMap model) {

		model.addAttribute("car",carService.findAll());

		return View.NEW_CAR_VIEW;

	}

}
