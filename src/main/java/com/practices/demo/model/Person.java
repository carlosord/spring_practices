package com.practices.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.practices.demo.model.compositekey.ReserveCarDate;
import com.practices.demo.model.types.Gender;

/**
 * The Class Person.
 */
@Entity
@Table(name = "PEOPLE", uniqueConstraints = @UniqueConstraint(columnNames = { "dni" }))
public class Person extends BaseEntity {

	/** The car. */
	@ManyToMany(mappedBy = "person")
	private Set<Car> car = new HashSet<>();

	/** The hotel. */
	@ManyToMany(mappedBy = "person")
	private Set<Hotel> hotel = new HashSet<>();

	/** The dates. */
	@OneToMany(mappedBy = "person")
	Set<ReserveCarDate> dates;

	/** The dni. */
	@NotEmpty
	@Column(name = "dni", nullable = false)
	@Size(min = 9, max = 9)
	private String dni;

	/** The name. */
	@Column(name = "name", nullable = true)
	private String name;

	/** The lastname. */
	@Column(name = "lastname", nullable = true)
	private String lastname;

	/** The age. */
	@Column(name = "birthday", nullable = true)
	private Date birthday;

	/** The gender. */
	@Column(name = "gender", nullable = true)
	private Gender gender;

	/**
	 * Instantiates a new person.
	 */
	public Person() {
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param dni the dni
	 */
	public Person(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
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
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
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
		return "Person [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday
				+ ", gender=" + gender;
	}

	/**
	 * Gets the hotel.
	 *
	 * @return the hotel
	 */
	public Set<Hotel> getHotel() {
		return new HashSet<>(this.hotel);
	}

	/**
	 * Gets the hotel.
	 *
	 * @return the hotel
	 */
	Set<Hotel> _getHotel() {
		return this.hotel;
	}

	/**
	 * Sets the hotel.
	 *
	 * @param hotel the new hotel
	 */
	public void setHotel(Set<Hotel> hotel) {
		this.hotel = hotel;
	}

	/**
	 * Gets the Car.
	 *
	 * @return the new car
	 */
	public Set<Car> getCar() {
		return new HashSet<>(this.car);
	}

	/**
	 * Gets the car.
	 *
	 * @return the car
	 */
	Set<Car> _getCar() {
		return this.car;
	}

	/**
	 * Sets the Car.
	 *
	 * @param car the new car
	 */
	public void setCar(Set<Car> car) {
		this.car = car;
	}

}