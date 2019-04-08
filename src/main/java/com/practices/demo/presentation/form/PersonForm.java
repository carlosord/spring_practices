package com.practices.demo.presentation.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.practices.demo.model.Person;
import com.practices.demo.model.types.Gender;

public class PersonForm {

	private Long id;

	@NotBlank(message="{person.dni.error.required}")
	@Pattern(regexp="[0-9]{8}([a-z]|[A-Z]){1}", message="{person.dni.error.invalid}")
	private String dni;

	@NotBlank(message="{person.name.error.required}")
	@Length(min=3, max=15, message="{person.name.error.notlength}")
	private String name;

	@NotBlank(message="{person.lastname.error.required}")
	@Length(min=3, max=15, message="{person.lastname.error.notlength}")
	private String lastname;

	@NotNull(message="{person.age.error.required}")
	@Min(value=18, message="{person.age.error.outofrange}")
	@Max(value=65, message="{person.age.error.outofrange}")
	private Integer age;

	@NotNull(message="{person.gender.error.required}")
	private Gender gender;

	private Boolean hascar;

	public Person toPerson() {
		Person p = new Person();
		p.setId(id);
		p.setDni(dni);
		p.setName(name);
		p.setLastname(lastname);
		p.setAge(age);
		p.setGender(gender);
		p.setHascar(hascar);
		return p;
	}
	
	public void getPersonForm(Person person) {
		this.setId(person.getId());
		this.setDni(person.getDni());
		this.setName(person.getName());
		this.setLastname(person.getLastname());
		this.setAge(person.getAge());
		this.setGender(person.getGender());
		this.setHascar(person.getHascar());
	}
	
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
