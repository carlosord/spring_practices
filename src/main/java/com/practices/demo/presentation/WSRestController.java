package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practices.demo.presentation.front.Url;
import com.practices.demo.service.HotelReserveService;


/**
 * The Class WSRestController.
 */
@RestController
public class WSRestController {

	/** The hotel reserve service. */
	@Autowired
	private HotelReserveService hotelReserveService;

	/**
	 * Last week reserves.
	 *
	 * @return the response entity
	 */
	@GetMapping(Url.LASTWEEK_RESERVES_URL)
	public ResponseEntity<Object> lastWeekReserves(){
		return new ResponseEntity<> (hotelReserveService.findHotelReserveLastWeek(), HttpStatus.OK);
	}

}
