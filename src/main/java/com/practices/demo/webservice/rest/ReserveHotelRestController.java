package com.practices.demo.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practices.demo.service.HotelReserveService;


/**
 * The Class ReserveHotelRestController.
 */
@RestController
public class ReserveHotelRestController {

	/** The hotel reserve service. */
	@Autowired
	private HotelReserveService hotelReserveService;

	/**
	 * Last week reserves.
	 *
	 * @return the response entity
	 */
	@GetMapping("/lastweekreserves")
	public ResponseEntity<Object> lastWeekReserves(){
		return new ResponseEntity<> (hotelReserveService.findHotelReserveLastWeek(), HttpStatus.OK);
	}


}
