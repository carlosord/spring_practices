package com.practices.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Class ReserveHotelDay.
 */
@Entity
@Table(name = "RESERVEHOTEL", uniqueConstraints = @UniqueConstraint(columnNames = { "person_id", "hotel_id",
		"startReserve", "finishReserve" }))
public class ReserveHotel extends BaseEntity {

	/** The person. */
	@ManyToOne
	private Person person;

	/** The hotel. */
	@ManyToOne
	private Hotel hotel;

	/** The start reserve. */
	private Date startReserve;

	/** The finish reserve. */
	private Date finishReserve;

	/**
	 * Instantiates a new reserve hotel day.
	 */
	public ReserveHotel() {
	}

	/**
	 * Instantiates a new reserve hotel.
	 *
	 * @param p             the p
	 * @param h             the h
	 * @param startReserve  the start reserve
	 * @param finishReserve the finish reserve
	 */
	public ReserveHotel(Person p, Hotel h, Date startReserve, Date finishReserve) {

		Associations.BookHotel.link(this, h, p);

		this.startReserve = startReserve;
		this.finishReserve = finishReserve;
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
	 * Gets the hotel.
	 *
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
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
	 * Gets the finish reserve.
	 *
	 * @return the finish reserve
	 */
	public Date getFinishReserve() {
		return finishReserve;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finishReserve == null) ? 0 : finishReserve.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((startReserve == null) ? 0 : startReserve.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReserveHotel other = (ReserveHotel) obj;
		if (finishReserve == null) {
			if (other.finishReserve != null)
				return false;
		} else if (!finishReserve.equals(other.finishReserve))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (startReserve == null) {
			if (other.startReserve != null)
				return false;
		} else if (!startReserve.equals(other.startReserve))
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ReserveDate [person=" + person + ", hotel=" + hotel + ", startReserve=" + startReserve
				+ ", finishReserve=" + finishReserve + "]";
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
	 * Sets the hotel.
	 *
	 * @param hotel the new hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	 * Sets the finish reserve.
	 *
	 * @param finishReserve the new finish reserve
	 */
	public void setFinishReserve(Date finishReserve) {
		this.finishReserve = finishReserve;
	}

}
