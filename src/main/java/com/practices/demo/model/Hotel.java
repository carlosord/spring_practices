package com.practices.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

/**
 * The class Hotel.
 *
 */
@Entity
@Table(name = "HOTEL", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class Hotel extends BaseEntity {

	/** The code. */
	@NotEmpty
	@Column(name = "code", nullable = false)
	private String code;

	/** The foreign key. */
	@ManyToOne
	private Person person;

	/** The name of hotel. */
	@Column(name = "name", nullable = false)
	private String name;

	/** The location. */
	@Column(name = "location", nullable = false)
	private String location;

	/** The total bedrooms. */
	@Column(name = "totalbedrooms", nullable = false)
	private int totalbedrooms;

	/** The occupied bedrooms. */
	@Column(name = "occupiedbedrooms")
	private int occupiedbedrooms;

	/**
	 * Instantiates a new hotel.
	 */
	public Hotel() {

	}

	/**
	 * Instantiates a new hotel.
	 *
	 * @param code the code
	 */
	public Hotel(String code) {
		this.code = code;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the name of the hotel.
	 *
	 * @return the name of the hotel
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the hotel.
	 *
	 * @param code the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param hascar the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the total bedrooms.
	 *
	 * @return the totalBedrooms
	 */
	public int getTotalbedrooms() {
		return totalbedrooms;
	}

	/**
	 * Sets the total bedrooms.
	 *
	 * @param hascar the new totalBedrooms
	 */
	public void setTotalbedrooms(int totalbedrooms) {
		this.totalbedrooms = totalbedrooms;
	}

	/**
	 * Gets the occupied bedrooms.
	 *
	 * @return the name occupiedBedrooms
	 */
	public int getOccupiedbedrooms() {
		return occupiedbedrooms;
	}

	/**
	 * Sets the occupied bedrooms.
	 *
	 * @param hascar the new ocuppiedBedrooms
	 */
	public void setOccupiedbedrooms(int occupiedbedrooms) {
		this.occupiedbedrooms = occupiedbedrooms;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Hotel other = (Hotel) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [code=" + code + ", person=" + person + ", name=" + name + ", location=" + location
				+ ", totalbedrooms=" + totalbedrooms + ", occupiedbedrooms=" + occupiedbedrooms + "]";
	}

	/**
	 * Gets the person.
	 *
	 * @param person
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
	public void setPerson(Person p) {
		this.person = p;
	}

}
