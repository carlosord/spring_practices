package com.practices.demo.validations.forms;

import java.text.SimpleDateFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Gender;

public class PersonForm {

	private long id;

	@NotNull
	private String dni;

	@NotNull
	private String fullname;

	@NotNull
	@Length(min = 3, max = 15, message = "{name.notvalid}")
	private String name;

	@NotNull
	@Length(min = 3, max = 15, message = "{lastname.notvalid}")
	private String lastname;

	@NotNull
	@Min(value = 18, message = "{age.error}")
	@Max(value = 65, message = "{age.error}")
	private int age;

	private Gender gender;
	private boolean hascar;


	@NotNull
	@Min(value = 1)
	@Max(value = 31)
	private String day;

	@NotNull
	@Min(value = 1)
	@Max(value = 12)
	private String month;

	@NotNull
	@Min(value = 1900)
	private String year;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public PersonaDTO toPerson() {

		PersonaDTO p = new PersonaDTO();

		//String fechanac = this.day + '/' + this.month + '/' + this.year;

		p.setId(id);
		p.setDni(dni);
		p.setName(name);
		p.setLastname(lastname);
		p.setAge(age);
		p.setGender(gender);
		p.setHascar(hascar);
		p.setFullname(fullname);
		// p.setDay(day)+'/'+setMonth(month)+'/'+setYear(year);
		p.setFechanac(day + '/' + month + '/' + year);

//
//		try {
//			p.setFechanac(format.parse(fechanac));
//		} catch (ParseException e) {
//			p.setFechanac(null);
//		}

		return p;

	}

	public void getPersonForm(PersonaDTO pe) {

		this.setId(pe.getId());
		this.setDni(pe.getDni());
		this.setName(pe.getName());
		this.setLastname(pe.getLastname());
		this.setAge(pe.getAge());
		this.setGender(pe.getGender());
		this.setHascar(pe.isHascar());
		this.setFullname(pe.getFullname());
		// this.setFechanac(format.format(pe.getFechanac()));

		String[] camposFecha = pe.getFechanac().split("/");
		this.setDay(camposFecha[0]);
		this.setMonth(camposFecha[1]);
		this.setYear(camposFecha[2]);



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

	public void setHascar(boolean hascar) {
		this.hascar = hascar;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}





}
