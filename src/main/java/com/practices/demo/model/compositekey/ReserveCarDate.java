package com.practices.demo.model.compositekey;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.practices.demo.model.Car;
import com.practices.demo.model.Person;

/**
 * The Class ReserveCar.
 */
@Entity
public class ReserveCarDate {

	/** The reserveid. */
	@EmbeddedId
	ReserveCarDateKey reserveid;

	/** The person. */
	@ManyToOne
	@MapsId("person_id")
	@JoinColumn(name = "person_id")
	Person person;

	/** The car. */
	@ManyToOne
	@MapsId("car_id")
	@JoinColumn(name = "car_id")
	Car car;

	/** The startdatereserve. */
	private Date startdatereserve;

	/** The finaldatereserve. */
	private Date finaldatereserve;

	/**
	 * Gets the reserveid.
	 *
	 * @return the reserveid
	 */
	public ReserveCarDateKey getReserveid() {
		return reserveid;
	}

	/**
	 * Sets the reserveid.
	 *
	 * @param reserveid the new reserveid
	 */
	public void setReserveid(ReserveCarDateKey reserveid) {
		this.reserveid = reserveid;
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
	 * Gets the startdatereserve.
	 *
	 * @return the startdatereserve
	 */
	public Date getStartdatereserve() {
		return startdatereserve;
	}

	/**
	 * Sets the startdatereserve.
	 *
	 * @param startdatereserve the new startdatereserve
	 */
	public void setStartdatereserve(Date startdatereserve) {
		this.startdatereserve = startdatereserve;
	}

	/**
	 * Gets the finaldatereserve.
	 *
	 * @return the finaldatereserve
	 */
	public Date getFinaldatereserve() {
		return finaldatereserve;
	}

	/**
	 * Sets the finaldatereserve.
	 *
	 * @param finaldatereserve the new finaldatereserve
	 */
	public void setFinaldatereserve(Date finaldatereserve) {
		this.finaldatereserve = finaldatereserve;
	}

}
