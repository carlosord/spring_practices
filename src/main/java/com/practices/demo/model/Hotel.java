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

import com.practices.demo.model.compositekey.ReserveHotelDay;

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

	/** The person key. */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_hotel", joinColumns = @JoinColumn(name = "hotel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
	private Set<Person> person;

	/** The reserve hotel day. */
	@OneToMany(mappedBy = "hotel")
	private Set<ReserveHotelDay> reserveHotelDay;

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
		return "Hotel [code=" + code + ", person=" + person + ", name=" + name + ", location=" + location
				+ ", totalbedrooms=" + totalbedrooms + ", occupiedbedrooms=" + occupiedbedrooms + "]";
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

	/**
	 * Gets the reserve hotel day.
	 *
	 * @return the reserve hotel day
	 */
	public Set<ReserveHotelDay> getReserveHotelDay() {
		return reserveHotelDay;
	}

	/**
	 * Gets the reserve hotel day.
	 *
	 * @return the sets the
	 */
	Set<ReserveHotelDay> _getReserveHotelDay(){
		return reserveHotelDay;
	}

	/**
	 * Sets the reserve hotel day.
	 *
	 * @param reserveHotelDay the new reserve hotel day
	 */
	public void setReserveHotelDay(Set<ReserveHotelDay> reserveHotelDay) {
		this.reserveHotelDay = reserveHotelDay;
	}

}
