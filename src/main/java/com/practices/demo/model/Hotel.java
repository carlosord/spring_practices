package com.practices.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

	/** The reserve hotel. */
	@OneToMany(mappedBy = "hotel")
	Set<ReserveHotel> reserveHotel;

	/** The code. */
	@NotEmpty
	@Column(name = "code", nullable = false)
	private String code;

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
	 * @param name the new name
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
	 * @param location the new location
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
	 * @param totalbedrooms the new totalbedrooms
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
	 * @param occupiedbedrooms the new occupiedbedrooms
	 */
	public void setOccupiedbedrooms(int occupiedbedrooms) {
		this.occupiedbedrooms = occupiedbedrooms;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Hotel other = (Hotel) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [code=" + code + ", name=" + name + ", location=" + location + ", totalbedrooms=" + totalbedrooms
				+ ", occupiedbedrooms=" + occupiedbedrooms + "]";
	}

	/**
	 * Gets the reserve hotel.
	 *
	 * @return the reserve hotel
	 */
	public Set<ReserveHotel> getReserveHotel() {
		return reserveHotel;
	}

	/**
	 * Sets the reserve hotel.
	 *
	 * @param reserveHotel the new reserve hotel
	 */
	public void setReserveHotel(Set<ReserveHotel> reserveHotel) {
		this.reserveHotel = reserveHotel;
	}

}
