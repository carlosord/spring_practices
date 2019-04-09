package com.practices.demo.dto;

import com.practices.demo.model.types.Gender;

public class PersonDto {
	
	private Long id;
	private String dni;
	private String name;
	private String lastname;
	private Integer age;
	private Gender gender;
	private Boolean hascar;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Boolean getHascar() {
		return hascar;
	}
	public void setHascar(Boolean hascar) {
		this.hascar = hascar;
	}
}
