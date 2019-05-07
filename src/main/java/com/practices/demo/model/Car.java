package com.practices.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.practices.demo.model.compositekey.ReserveCarDate;

/**
 * The Class Person.
 */
@Entity
@Table(name = "CAR", uniqueConstraints = @UniqueConstraint(columnNames = { "license" }))

public class Car extends BaseEntity {

	/** The foreign key. */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_car", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
	private Set<Person> person;

	/** The dates. */
	@OneToMany(mappedBy = "car")
	Set<ReserveCarDate> dates;

	/** The car license. */
	@NotEmpty
	@Column(name = "license", nullable = false)
	private String license;

	/** The car colour. */
	@Column(name = "colour", nullable = true)
	private String colour;

	/** The number of car doors. */
	@Column(name = "numberofcardoors", nullable = true)
	private Integer numberofcardoors;

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
	public Integer getNumberofcardoors() {
		return numberofcardoors;
	}

	/**
	 * Sets the number of car doors.
	 *
	 * @param numberofcardoors the new number of car doors
	 */
	public void setNumberofcardoors(Integer numberofcardoors) {
		this.numberofcardoors = numberofcardoors;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Car [license=" + license + ", colour=" + colour + ", numberOfCarDoors=" + numberofcardoors + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
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

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Set<Person> getPerson() {
		return person;
	}

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	Set<Person> _getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 *
	 * @param p the new person
	 */
	public void setPerson(Set<Person> p) {
		this.person = p;
	}

}
