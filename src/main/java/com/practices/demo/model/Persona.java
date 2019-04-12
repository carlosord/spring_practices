package com.practices.demo.model;

import java.util.Date;

import javax.persistence.*;


/**
 *	Esta clase es la principal, la que se conecta con la base de datos.
 *
 * @author Daniel.perez
 *
 * @see BaseEntity
 */

@Entity
@Table(name = "PEOPLE", uniqueConstraints = @UniqueConstraint(columnNames = { "dni" }))
public class Persona extends BaseEntity {

	private String dni;
	private String name;
	private String lastname;
	private Date fecha;
	private Gender gender;
	private boolean hascar;

	public Persona() {
	};

	/**
	 * Es el constructor.
	 *
	 * @param dni DNI del usuario
	 * @param name Nombre del usuario
	 * @param lastname Apellido del usuario
	 * @param gender Genero del usuario
	 * @param car Indica si tiene coche o no
	 * @param fecha Indica la fecha de cumpleaños del usuario
	 *
	 *
	 */
	public Persona(String dni, String name, String lastname, Gender gender, boolean car,Date fecha) {
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
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
		return "Persona dni= " + dni + ", name=" + name + ", lastname=" + lastname + ", gender="
				+ gender + ", car=" + hascar;
	}

}
