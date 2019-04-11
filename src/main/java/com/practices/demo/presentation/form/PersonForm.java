package com.practices.demo.presentation.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Gender;

public class PersonForm {

	private long id;

	@NotBlank(message="{dni.error.required}")
	@Pattern(regexp="[0-9]{8}([a-z]|[A-Z]){1}", message="{error.dni.invalid}")
	private String dni;

	private String fullname;

	@NotBlank(message="{name.error.required}")
	@Length(min=3, max=15, message="{name.error.notlength}")
	private String name;

	@NotBlank(message="{lastname.error.required}")
	@Length(min=3, max=15, message="{lastname.error.notlength}")
	private String lastname;

	@NotNull(message="{age.error.required}")
	@Min(value=18, message="{age.error.outofrange}")
	@Max(value=65, message="{age.error.outofrange}")
	private int age;
	@Pattern(regexp="^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message="{error.date.formatinvalid}")
	private String fecha;

	@NotNull(message="{gender.error.required}")
	private Gender gender;
	private boolean hascar;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public PersonDto toPerson() {
		PersonDto p = new PersonDto();

		p.setId(id);
		p.setDni(dni);
		p.setName(name);
		p.setLastname(lastname);
		p.setFullname(fullname);
		p.setAge(age);
		try {
			p.setFecha(format.parse(fecha));
		} catch (ParseException e) {
			p.setFecha(null);
		}
		p.setGender(gender);
		p.setHascar(hascar);

		return p;
	}

	public void getPersonForm(PersonDto pe) {

		this.setId(pe.getId());
		this.setDni(pe.getDni());
		this.setName(pe.getName());
		this.setLastname(pe.getLastname());
		this.setFullname(pe.getFullname());
		this.setAge(pe.getAge());
		this.setFecha(format.format(pe.getFecha()));
		this.setGender(pe.getGender());
		this.setHascar(pe.isHascar());
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

	public void setAge(int age) {
		this.age = age;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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

	public void setHascar(boolean hascar) {
		this.hascar = hascar;
	}

}
