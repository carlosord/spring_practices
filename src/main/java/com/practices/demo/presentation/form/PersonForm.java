package com.practices.demo.presentation.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Person;
import com.practices.demo.model.types.Gender;

/**
 * The Class PersonForm.
 */
public class PersonForm {

	/** The id. */
	private Long id;

	/** The dni. */
	@NotBlank(message="{person.dni.error.required}")
	@Pattern(regexp="[0-9]{8}([a-z]|[A-Z]){1}", message="{person.dni.error.invalid}")
	private String dni;

	/** The name. */
	@NotBlank(message="{person.name.error.required}")
	@Length(min=3, max=15, message="{person.name.error.notlength}")
	private String name;

	/** The lastname. */
	@NotBlank(message="{person.lastname.error.required}")
	@Length(min=3, max=15, message="{person.lastname.error.notlength}")
	private String lastname;

	/** The age. */
	@NotNull(message="{person.age.error.required}")
	@Min(value=18, message="{person.age.error.outofrange}")
	@Max(value=65, message="{person.age.error.outofrange}")
	private Integer age;

	/** The gender. */
	@NotNull(message="{person.gender.error.required}")
	private Gender gender;

	/** The hascar. */
	private Boolean hascar;

	/**
	 * To person.
	 *
	 * @return the person
	 */
	public PersonDto toPerson() {
		
		PersonDto p = new PersonDto();
		
		p.setId(id);
		p.setDni(dni);
		p.setName(name);
		p.setLastname(lastname);
		p.setAge(age);
		p.setGender(gender);
		p.setHascar(hascar);
		
		return p;
		
	}
	
	/**
	 * Gets the person form.
	 *
	 * @param person the person
	 * @return the person form
	 */
	public void getPersonForm(PersonDto person) {
		
		this.setId(person.getId());
		this.setDni(person.getDni());
		this.setName(person.getName());
		this.setLastname(person.getLastname());
		this.setAge(person.getAge());
		this.setGender(person.getGender());
		this.setHascar(person.getHascar());
		
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the hascar.
	 *
	 * @return the hascar
	 */
	public Boolean getHascar() {
		return hascar;
	}

	/**
	 * Sets the hascar.
	 *
	 * @param hascar the new hascar
	 */
	public void setHascar(Boolean hascar) {
		this.hascar = hascar;
	}

	
}
