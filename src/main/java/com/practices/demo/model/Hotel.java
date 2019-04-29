package com.practices.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

/**
 * The class Hotel.
 *
 */
@Entity
@Table(name = "HOTEL", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class Hotel {

	/** The code. */
	@NotEmpty
	@Column(name = "code", nullable = false)
	private int code;

	/** The location. */
	@Column(name = "location", nullable = false)
	private String location;

	/** The total bedrooms. */
	@Column(name = "totalBedrooms", nullable = false)
	private int totalBedrooms;

	/** The occupied bedrooms. */
	@Column(name = "occupiedBedrooms")
	private int occupiedBedrooms;


	/**
	 * Instantiates a new hotel.
	 */
	public Hotel() {

	}


	/**
	 * Instantiates a new hotel.
	 *
	 * @param code
	 *            the code
	 */
	public Hotel(int code) {
		this.code=code;
	}


	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}


	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(int code) {
		this.code = code;
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
	 * @param hascar
	 *            the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * Gets the total bedrooms.
	 *
	 * @return the totalBedrooms
	 */
	public int getTotalBedrooms() {
		return totalBedrooms;
	}


	/**
	 * Sets the total bedrooms.
	 *
	 * @param hascar
	 *            the new totalBedrooms
	 */
	public void setTotalBedrooms(int totalBedrooms) {
		this.totalBedrooms = totalBedrooms;
	}


	/**
	 * Gets the occupied bedrooms.
	 *
	 * @return the name occupiedBedrooms
	 */
	public int getOccupiedBedrooms() {
		return occupiedBedrooms;
	}


	/**
	 * Sets the occupied bedrooms.
	 *
	 * @param hascar
	 *            the new ocuppiedBedrooms
	 */
	public void setOccupiedBedrooms(int occupiedBedrooms) {
		this.occupiedBedrooms = occupiedBedrooms;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [code=" + code + ", location=" + location + ", totalBedrooms=" + totalBedrooms
				+ ", occupiedBedrooms=" + occupiedBedrooms + "]";
	};





}
