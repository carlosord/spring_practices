package com.practices.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *	En esta clase está la Id que se le asigna a cada {@code Persona} a la hora de registrarlos
 * @author Daniel.perez
 *
 */

@MappedSuperclass
public class BaseEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}







}
