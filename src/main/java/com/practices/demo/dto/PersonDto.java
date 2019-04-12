package com.practices.demo.dto;


import com.practices.demo.model.Gender;

/**
 * Esta clase es como la "intermediaria" que intercambia los datos con {@code Persona} y pasandolos a {@code PersonForm}.
 * @author Daniel.perez
 *
 */
public class PersonDto{

	private long id;
	private String dni;
	private String name;
	private String lastname;
	private String fullname;
	private int age;
	private String fecha;
	private Gender gender;
	private boolean hascar;

	public PersonDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public void setHascar(boolean hascar) {
		this.hascar = hascar;
	}

}
