package com.practices.demo.presentation.form;

import javax.validation.constraints.NotBlank;

import com.practices.demo.dto.CarReserveDto;

/**
 * The Class CarForm.
 */
public class CarForm {

	/** The Dni. */
	private String dni;

	/** The car license. */
	private String license;

	/** The startreserveday. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String startreserveday;

	/** The startreservemonth. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String startreservemonth;

	/** The startreserveyear. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String startreserveyear;

	/** The finishreserveday. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String finishreserveday;

	/** The finishreservemonth. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String finishreservemonth;

	/** The finishreserveyear. */
	@NotBlank(message = "{person.reserve.error.required}")
	private String finishreserveyear;

	/**
	 * To car.
	 *
	 * @return the car reserve dto
	 */
	public CarReserveDto toCar() {

		CarReserveDto c = new CarReserveDto();

		c.setDni(dni);
		c.setLicense(license);
		c.setStartCarReserve(String.join("/", startreserveday, startreservemonth, startreserveyear));
		c.setFinishCarReserve(String.join("/", finishreserveday, finishreservemonth, finishreserveyear));
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

	/**
	 * Gets the startreserveday.
	 *
	 * @return the startreserveday
	 */
	public String getStartreserveday() {
		return startreserveday;
	}

	/**
	 * Sets the startreserveday.
	 *
	 * @param startreserveday the new startreserveday
	 */
	public void setStartreserveday(String startreserveday) {
		this.startreserveday = startreserveday;
	}

	/**
	 * Gets the startreservemonth.
	 *
	 * @return the startreservemonth
	 */
	public String getStartreservemonth() {
		return startreservemonth;
	}

	/**
	 * Sets the startreservemonth.
	 *
	 * @param startreservemonth the new startreservemonth
	 */
	public void setStartreservemonth(String startreservemonth) {
		this.startreservemonth = startreservemonth;
	}

	/**
	 * Gets the startreserveyear.
	 *
	 * @return the startreserveyear
	 */
	public String getStartreserveyear() {
		return startreserveyear;
	}

	/**
	 * Sets the startreserveyear.
	 *
	 * @param startreserveyear the new startreserveyear
	 */
	public void setStartreserveyear(String startreserveyear) {
		this.startreserveyear = startreserveyear;
	}

	/**
	 * Gets the finishreserveday.
	 *
	 * @return the finishreserveday
	 */
	public String getFinishreserveday() {
		return finishreserveday;
	}

	/**
	 * Sets the finishreserveday.
	 *
	 * @param finishreserveday the new finishreserveday
	 */
	public void setFinishreserveday(String finishreserveday) {
		this.finishreserveday = finishreserveday;
	}

	/**
	 * Gets the finishreservemonth.
	 *
	 * @return the finishreservemonth
	 */
	public String getFinishreservemonth() {
		return finishreservemonth;
	}

	/**
	 * Sets the finishreservemonth.
	 *
	 * @param finishreservemonth the new finishreservemonth
	 */
	public void setFinishreservemonth(String finishreservemonth) {
		this.finishreservemonth = finishreservemonth;
	}

	/**
	 * Gets the finishreserveyear.
	 *
	 * @return the finishreserveyear
	 */
	public String getFinishreserveyear() {
		return finishreserveyear;
	}

	/**
	 * Sets the finishreserveyear.
	 *
	 * @param finishreserveyear the new finishreserveyear
	 */
	public void setFinishreserveyear(String finishreserveyear) {
		this.finishreserveyear = finishreserveyear;
	}

}
