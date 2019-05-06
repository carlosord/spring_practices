package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practices.demo.presentation.form.HotelForm;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.front.View;
import com.practices.demo.service.HotelService;

/**
 * The Class HotelController.
 */
@Controller
public class HotelController {

	/** The hotel repository. */
	@Autowired
	private HotelService hotelService;

	/**
	 * Show all.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.HOTEL_URL + "/{dni}")
	public String showAll(@PathVariable("dni") String dni, ModelMap model) {

		// Add all hotel to model
		model.addAttribute("allHotels", hotelService.findAll());
		model.addAttribute("hotelForm", new HotelForm());

		HotelForm hotelForm = new HotelForm();
		hotelForm.setDni(dni);

		model.addAttribute("hotelForm", hotelForm);

		// Return home view
		return View.HOTEL_VIEW;

	}

}
