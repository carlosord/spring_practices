package com.practices.demo.model.compositekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ReserveCarKey.
 */
@Embeddable
public class ReserveCarDateKey implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The personId */
	@Column(name = "person_id")
	Long personId;

	/** The carId */
	@Column(name = "car_id")
	Long carId;

	/**
	 * Gets the person id.
	 *
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Sets the person id.
	 *
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Gets the car id.
	 *
	 * @return the carId
	 */
	public Long getCarId() {
		return carId;
	}

	/**
	 * Sets the car id.
	 *
	 * @param carId the carId to set
	 */
	public void setCarId(Long carId) {
		this.carId = carId;
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
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
		ReserveCarDateKey other = (ReserveCarDateKey) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

}
