package com.practices.demo.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "PEOPLE", uniqueConstraints = @UniqueConstraint(columnNames = { "dni" }))
public class Persona extends BaseEntity {

	private String dni;
	private String name;
	private String lastname;
	private int age;
	private Date fecha;
	private Gender gender;
	private boolean hascar;

	public Persona() {
	};

	public Persona(String dni, String name, String lastname,int age, Gender gender, boolean car,Date fecha) {
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.age=age;
		this.gender = gender;
		this.hascar = car;
		this.fecha=fecha;
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

	public String getFullname() {
		return this.name + " " + this.lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public void setHascar(boolean car) {
		this.hascar = car;
	}

	@Override
	public String toString() {
		return "Persona dni= " + dni + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", car=" + hascar;
	}

}
