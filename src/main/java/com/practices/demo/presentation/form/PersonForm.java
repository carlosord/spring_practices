package com.practices.demo.presentation.form;


import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Gender;

/**
 * Esta clase se encarga de mostrar en el formulario toda la información.
 * @author Daniel.perez
 *
 */
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
//	@Min(value=18, message="{age.error.outofrange}")
//	@Max(value=65, message="{age.error.outofrange}")
	private int age;

	@NotNull(message="{gender.error.required}")
	private Gender gender;
	private boolean hascar;

	@NotBlank(message="{day.error.required}")
	@Min(value=1)
	@Max(value=31)
	private String day;

	@NotBlank(message="{month.error.required}")
	@Min(value=1)
	@Max(value=12)
	private String month;

	@NotBlank(message="{year.error.required}")
	@Min(value=1900)
	private String year;

	/**
	 * Este método se encarga de enviar la información de {@code PersonForm} a {@code PersonDto}
	 * @return Retorna un objeto {@code PersonDto}
	 */
	public PersonDto toPerson() {
		PersonDto p = new PersonDto();

		p.setId(id);
		p.setDni(dni);
		p.setName(name);
		p.setLastname(lastname);
		p.setFullname(fullname);
		p.setAge(age);
		p.setFecha(day+'/'+month+'/'+year);
		p.setGender(gender);
		p.setHascar(hascar);

		return p;
	}

	/**
	 * Este metodo se encarga de enviar la información de {@code PersonDto} a {@code PersonForm}
	 * @param Retorna un objeto {@code PersonForm}
	 */
	public void getPersonForm(PersonDto pe) {

		String[] camposFecha = pe.getFecha().split("/");
		this.setDay(camposFecha[0]);
		this.setMonth(camposFecha[1]);
		this.setYear(camposFecha[2]);


		this.setId(pe.getId());
		this.setDni(pe.getDni());
		this.setName(pe.getName());
		this.setLastname(pe.getLastname());
		this.setFullname(pe.getFullname());
		this.setAge(pe.getAge());
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
