package com.practices.demo.dto;

import java.util.List;

/**
 * The Class InfoPersonDto.
 */
public class InfoPersonDto {

	/** The person. */
	private PersonDto person;

	/** The hotel list. */
	private List<ReserveHotelDto> hotelList;

	/** The car list. */
	private List<CarReserveDto> carList;

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public PersonDto getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 *
	 * @param person the new person
	 */
	public void setPerson(PersonDto person) {
		this.person = person;
	}

	/**
	 * Gets the hotel list.
	 *
	 * @return the hotel list
	 */
	public List<ReserveHotelDto> getHotelList() {
		return hotelList;
	}

	/**
	 * Sets the hotel list.
	 *
	 * @param hotelList the new hotel list
	 */
	public void setHotelList(List<ReserveHotelDto> hotelList) {
		this.hotelList = hotelList;
	}

	/**
	 * Gets the car list.
	 *
	 * @return the car list
	 */
	public List<CarReserveDto> getCarList() {
		return carList;
	}

	/**
	 * Sets the car list.
	 *
	 * @param carList the new car list
	 */
	public void setCarList(List<CarReserveDto> carList) {
		this.carList = carList;
	}

}
