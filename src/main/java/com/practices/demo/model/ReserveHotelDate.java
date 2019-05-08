package com.practices.demo.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.practices.demo.model.compositekey.ReserveHotelKey;

/**
 * The Class ReserveHotelDay.
 */
@Entity
public class ReserveHotelDate {

	/** The reserve. */
	@EmbeddedId
	private ReserveHotelKey reserve;

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

	/** The start reserve. */
	private Date startReserve;

	/** The finish reserve. */
	private Date finishReserve;


	/**
	 * Instantiates a new reserve hotel day.
	 */
	public ReserveHotelDate() {
	}

	/**
	 * Gets the reserve.
	 *
	 * @return the reserve
	 */
	public ReserveHotelKey getReserve() {
		return reserve;
	}

	/**
	 * Sets the reserve.
	 *
	 * @param reserve the new reserve
	 */
	public void setReserve(ReserveHotelKey reserve) {
		this.reserve = reserve;
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
	public Date getStartReserve() {
		return startReserve;
	}

	/**
	 * Sets the start reserve.
	 *
	 * @param startReserve the new start reserve
	 */
	public void setStartReserve(Date startReserve) {
		this.startReserve = startReserve;
	}

	/**
	 * Gets the finish reserve.
	 *
	 * @return the finish reserve
	 */
	public Date getFinishReserve() {
		return finishReserve;
	}

	/**
	 * Sets the finish reserve.
	 *
	 * @param finishReserve the new finish reserve
	 */
	public void setFinishReserve(Date finishReserve) {
		this.finishReserve = finishReserve;
	}
}
