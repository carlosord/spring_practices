package com.practices.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity(name = "PEOPLE")
@Table(name = "PEOPLE", uniqueConstraints = @UniqueConstraint(columnNames = { "dni" }))
public class Persona extends BaseEntity {

	@NotEmpty
	private String dni;

	private String name;
	private String lastname;
	private int age;
	private Gender gender;
	private boolean hascar;
	private Date fechanac;


	public Persona() {
	};

	public Persona(String dni, String name, String lastname, int age, Gender gender, boolean hascar, Date fechanac) {

		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.fechanac= fechanac;

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", car=" + hascar + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isHascar() {
		return hascar;
	}

	public void setHascar(boolean car) {
		this.hascar = car;
	}

	public String getFullname() {
		return this.name + " " + this.lastname;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}



}
