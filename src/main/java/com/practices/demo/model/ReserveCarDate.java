package com.practices.demo.model;

//import java.io.Serializable;
import java.util.Date;

//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//
//import com.practices.demo.model.compositekey.ReserveCarDateKey;

/**
 * The Class ReserveCarDate.
 */
@Entity
public class ReserveCarDate {

	/** The reserveid. */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@EmbeddedId
//	ReserveCarDateKey id;

	/** The person. */
	@ManyToOne
//	@MapsId("person_id")
//	@JoinColumn(name = "person_id")
	Person person;

	/** The car. */
	@ManyToOne
//	@MapsId("car_id")
//	@JoinColumn(name = "car_id")
	Car car;

	/** The start car reserve. */
	private Date startCarReserve;

	/** The finish car reserve. */
	private Date finishCarReserve;

	/**
	 * Instantiates a new reserve car date.
	 */
	public ReserveCarDate() {
	}

//	/**
//	 * Gets the reserveid.
//	 *
//	 * @return the reserveid
//	 */
//	public ReserveCarDateKey getReserveid() {
//		return id;
//	}
//
//	/**
//	 * Sets the reserveid.
//	 *
//	 * @param reserveid the new reserveid
//	 */
//	public void setReserveid(ReserveCarDateKey reserveid) {
//		this.id = reserveid;
//	}

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
	 * Gets the start car reserve.
	 *
	 * @return the startCarReserve
	 */
	public Date getStartCarReserve() {
		return startCarReserve;
	}

	/**
	 * Sets the start car reserve.
	 *
	 * @param startCarReserve the startCarReserve to set
	 */
	public void setStartCarReserve(Date startCarReserve) {
		this.startCarReserve = startCarReserve;
	}

	/**
	 * Gets the finish car reserve.
	 *
	 * @return the finishCarReserve
	 */
	public Date getFinishCarReserve() {
		return finishCarReserve;
	}

	/**
	 * Sets the finish car reserve.
	 *
	 * @param finishCarReserve the finishCarReserve to set
	 */
	public void setFinishCarReserve(Date finishCarReserve) {
		this.finishCarReserve = finishCarReserve;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
