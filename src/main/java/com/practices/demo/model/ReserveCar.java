package com.practices.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Class ReserveCarDate.
 */
@Entity
@Table(name = "RESERVECARDATE", uniqueConstraints = @UniqueConstraint(columnNames = { "person_id", "car_id",
		"startReserve", "finishReserve" }))
public class ReserveCar extends BaseEntity {

	/** The person. */
	@ManyToOne
	private Person person;

	/** The car. */
	@ManyToOne
	private Car car;

	/** The start car reserve. */
	private Date startReserve;

	/** The finish car reserve. */
	private Date finishReserve;

	/**
	 * Instantiates a new reserve car date.
	 */
	public ReserveCar() {
	}

	/**
	 * Instantiates a new reserve car date.
	 *
	 * @param p                  the p
	 * @param c                  the c
	 * @param startHotelReserve  the start hotel reserve
	 * @param finishHotelReserve the finish hotel reserve
	 */
	public ReserveCar(Person p, Car c, Date startHotelReserve, Date finishHotelReserve) {

		Associations.BookCar.link(this, c, p);

		this.startReserve = startHotelReserve;
		this.finishReserve = finishHotelReserve;
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
	 * Gets the car.
	 *
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * Sets the car.
	 *
	 * @param car the new car
	 */
	public void setCar(Car car) {
		this.car = car;
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((finishReserve == null) ? 0 : finishReserve.hashCode());
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
		ReserveCar other = (ReserveCar) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (finishReserve == null) {
			if (other.finishReserve != null)
				return false;
		} else if (!finishReserve.equals(other.finishReserve))
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

}
