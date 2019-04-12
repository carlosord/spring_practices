package com.practices.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * En esta clase se le asigna un id a cada Persona
 * @author Jairo.Rodriguez
 *
 */

@MappedSuperclass
public class BaseEntity implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(length=255, nullable=false)
	private String dni;

	@Column(length=255, nullable=false)
	private String name;

	@Column(length=255, nullable=false)
	private String lastname;

	@Column(length=255, nullable=false)
	private int age;

	@Column(length=255, nullable=false)
	private Gender gender;


	public BaseEntity() {};

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



}
