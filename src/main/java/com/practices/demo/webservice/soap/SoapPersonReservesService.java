package com.practices.demo.webservice.soap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.localhost.spring_practices.InfoPersonRequest;
import com.localhost.spring_practices.InfoPersonResponse;
import com.localhost.spring_practices.ListCarType;
import com.localhost.spring_practices.ListHotelType;
import com.localhost.spring_practices.PersonType;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveCar;
import com.practices.demo.model.ReserveHotel;
import com.practices.demo.repositories.HotelReserveRepository;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.repositories.ReserveCarRepository;

/**
 * The Class SoapService.
 */
@Endpoint
public class SoapPersonReservesService {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/** The hotel reserve repository. */
	@Autowired
	private HotelReserveRepository hotelReserveRepository;

	/** The reserve car repository. */
	@Autowired
	private ReserveCarRepository reserveCarRepository;

	/**
	 * Instantiates a new soap service.
	 */
	@Autowired
	public SoapPersonReservesService() {
		System.err.println("CREANDO SERVICIO SOAP");
	}


	/**
	 * Show all reservations.
	 *
	 * @param request the request
	 * @return the info person response
	 */
	@SoapAction(value = "http://localhost.com/spring_practices/infoPersonRequest")
	@PayloadRoot(namespace="http://localhost.com/spring_practices", localPart="infoPersonRequest")
	@ResponsePayload
	public InfoPersonResponse showAllReservations(@RequestPayload InfoPersonRequest request) {
		InfoPersonResponse response = new InfoPersonResponse();

		Optional<Person> findedPerson = personRepository.findById(request.getId());

		PersonType person = new PersonType();
		person.setDni(findedPerson.get().getDni());
		response.setPerson(person);

		ReserveHotel findedHotel = (ReserveHotel) hotelReserveRepository.findByPersonDni(person.getDni());
		ListHotelType hotel = new ListHotelType();
		hotel.setName(findedHotel.getHotel().getName());
		hotel.setLocation(findedHotel.getHotel().getLocation());
		response.setListHotel(hotel);

		ReserveCar findedCar = (ReserveCar) reserveCarRepository.findByPersonDni(person.getDni());
		ListCarType car = new ListCarType();
		car.setLicense(findedCar.getCar().getLicense());
		car.setColour(findedCar.getCar().getColour());
		response.setListCar(car);

		return response;
	}

}
