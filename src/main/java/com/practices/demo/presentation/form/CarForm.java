package com.practices.demo.presentation.form;

import com.practices.demo.dto.CarReserveDto;

/**
 * The Class CarForm.
 */
public class CarForm {

	/**  The Dni. */
	private String dni;

	/** The car license. */
	private String license;

	/**
	 * To car.
	 *
	 * @return the car reserve dto
	 */
	public CarReserveDto toCar() {

		CarReserveDto c = new CarReserveDto();

		c.setDni(dni);
		c.setLicense(license);

		return c;

	}

	/**
	 * Gets the license.
	 *
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param license the new license
	 */
	public void setLicense(String license) {
		this.license = license;
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

}
