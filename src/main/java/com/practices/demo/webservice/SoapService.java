package com.practices.demo.webservice;

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

@Endpoint
public class SoapService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private HotelReserveRepository hotelReserveRepository;

	@Autowired
	private ReserveCarRepository reserveCarRepository;

	@Autowired
	public SoapService() {
		System.err.println("CREANDO SERVICIO SOAP");
	}


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
