package com.practices.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.practices.demo.model.types.Gender;

/**
 * The Class Person.
 */
@Entity
@Table(name = "PEOPLE", uniqueConstraints = @UniqueConstraint(columnNames = { "dni" }))
public class Person extends BaseEntity {

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

	/** The hasCar. */
	@Column(name = "hascar", nullable = true)
	private Boolean hascar;

	/**
	 * Instantiates a new person.
	 */
	public Person() {
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param dni
	 *            the dni
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
	 * @param dni
	 *            the new dni
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
	 * @param name
	 *            the new name
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
	 * @param lastname
	 *            the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getBirthday() {
		return birthday;
	}

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
	 * @param gender
	 *            the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the hascar.
	 *
	 * @return the hascar
	 */
	public Boolean getHascar() {
		return hascar;
	}

	/**
	 * Sets the hascar.
	 *
	 * @param hascar
	 *            the new hascar
	 */
	public void setHascar(Boolean hascar) {
		this.hascar = hascar;
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
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
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
		return "Person [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday + ", gender="
				+ gender + ", hascar=" + hascar + "]";
	}

}