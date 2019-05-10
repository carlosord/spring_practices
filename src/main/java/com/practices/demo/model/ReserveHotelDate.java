package com.practices.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * The Class ReserveHotelDate.
 */
@Entity
public class ReserveHotelDate extends BaseEntity{

	/** The person. */
	@ManyToOne
	@MapsId("person_id")
	@JoinColumn(name = "person_id")
	private Person person;

	/** The hotel. */
	@ManyToOne
	@MapsId("hotel_id")
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	/** The start hotel reserve. */
	private Date startHotelReserve;

	/** The finish hotel reserve. */
	private Date finishHotelReserve;

	/**
	 * Instantiates a new reserve hotel day.
	 */
	public ReserveHotelDate() {
	}

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 *
	 * @param person the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gets the hotel.
	 *
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * Sets the hotel.
	 *
	 * @param hotel the new hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * Gets the start reserve.
	 *
	 * @return the start reserve
	 */
	public Date getStartHotelReserve() {
		return startHotelReserve;
	}

	/**
	 * Sets the start reserve.
	 *
	 * @param startHotelReserve the new start reserve
	 */
	public void setStartReserve(Date startHotelReserve) {
		this.startHotelReserve = startHotelReserve;
	}

	/**
	 * Gets the finish reserve.
	 *
	 * @return the finish reserve
	 */
	public Date getFinishHotelReserve() {
		return finishHotelReserve;
	}

	/**
	 * Sets the finish reserve.
	 *
	 * @param finishHotelReserve the new finish hotel reserve
	 */
	public void setFinishHotelReserve(Date finishHotelReserve) {
		this.finishHotelReserve = finishHotelReserve;
	}
}