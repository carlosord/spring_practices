package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practices.demo.presentation.front.Url;
import com.practices.demo.service.HotelReserveService;
import com.practices.demo.service.PersonService;

/**
 * The Class WSRestController.
 */
@RestController
public class WSRestController {

	/** The hotel reserve service. */
	@Autowired
	private HotelReserveService hotelReserveService;

	/** The person service. */
	@Autowired
	private PersonService personService;

	/**
	 * Last week reserves.
	 *
	 * @return the response entity
	 */
	@GetMapping(Url.LASTWEEK_RESERVES_HOTEL_URL)
	public ResponseEntity<Object> lastWeekReserves() {
		return new ResponseEntity<>(hotelReserveService.findHotelReserveLastWeek(), HttpStatus.OK);
	}
	/**
	 * Show reserve hotel.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping(Url.RESERVES_HOTEL_URL + "/{id}")
	public ResponseEntity<Object> showReserveHotel(@PathVariable("id") Long id) {
		return new ResponseEntity<>(hotelReserveService.findPersonById(id), HttpStatus.OK);

	}

	/**
	 * Show reserves person.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping(Url.RESERVES_PERSON_URL + "/{id}")
	public ResponseEntity<Object> showReservesPerson(@PathVariable("id") Long id) {
		return new ResponseEntity<>(personService.showReservesPerson(id), HttpStatus.OK);

	}

}
