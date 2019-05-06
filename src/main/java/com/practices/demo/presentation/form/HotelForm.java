package com.practices.demo.presentation.form;

import com.practices.demo.dto.ReserveHotelDto;

/**
 * The Class HotelForm.
 */
public class HotelForm {

	/** The dni */
	private String dni;

	/** The code of hotel. */
	private String code;

	/**
	 * To hotel.
	 *
	 * @return the reserve hotel dto
	 */
	public ReserveHotelDto toHotel() {

		ReserveHotelDto p = new ReserveHotelDto();

		p.setDni(dni);
		p.setCode(code);

		return p;
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
	 *
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
