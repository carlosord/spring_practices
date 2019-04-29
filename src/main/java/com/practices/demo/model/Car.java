package com.practices.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

/**
 * The Class Person.
 */
@Entity
@Table(name = "CAR", uniqueConstraints = @UniqueConstraint(columnNames = { "license" }))

public class Car {

	/** The car license. */
	@NotEmpty
	@Column(name = "license", nullable = false)
	private String license;

	/** The car colour. */
	@Column(name = "colour", nullable = true)
	private String colour;

	/** The number of car doors. */
	@Column(name = "numberOfCarDoors", nullable = true)
	private int numberOfCarDoors;

	/**
	 * Instantiates a new car.
	 */
	public Car() {
	}

	/**
	 * Instantiates a new car.
	 *
	 * @param license the license
	 */
	public Car(String license) {
		this.license = license;
	}

	/**
	 * Gets the license.
	 *
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param license the new license
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the new colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Gets the number of car doors.
	 *
	 * @return the number of car doors
	 */
	public int getNumberOfCarDoors() {
		return numberOfCarDoors;
	}

	/**
	 * Sets the number of car doors.
	 *
	 * @param numberOfCarDoors the new number of car doors
	 */
	public void setNumberOfCarDoors(int numberOfCarDoors) {-
		this.numberOfCarDoors = numberOfCarDoors;
	}

	@Override
	public String toString() {
		return "Car [license=" + license + ", colour=" + colour + ", numberOfCarDoors=" + numberOfCarDoors + "]";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		return true;
	}

}
