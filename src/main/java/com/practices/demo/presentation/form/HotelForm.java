package com.practices.demo.presentation.form;

import javax.validation.constraints.NotBlank;

import com.practices.demo.dto.ReserveHotelDto;

/**
 * The Class HotelForm.
 */
public class HotelForm {

	/** The dni. */
	private String dni;

	/** The code of hotel. */
	private String code;

	/** The starthotelday. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String starthotelday;

	/** The starthotelmonth. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String starthotelmonth;

	/** The starthotelyear. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String starthotelyear;

	/** The finishhotelday. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String finishhotelday;

	/** The finishhotelmonth. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String finishhotelmonth;

	/** The finishhotelyear. */
	@NotBlank(message = "{reserve.hotel.error.required}")
	private String finishhotelyear;

	/**
	 * To hotel.
	 *
	 * @return the reserve hotel dto
	 */
	public ReserveHotelDto toHotel() {

		ReserveHotelDto r = new ReserveHotelDto();

		r.setDni(dni);
		r.setCode(code);
		r.setStartHotelReserve(String.join("/", starthotelday, starthotelmonth, starthotelyear));
		r.setFinishHotelReserve(String.join("/", finishhotelday, finishhotelmonth, finishhotelyear));

		return r;
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

	/**
	 * Gets the starthotelday.
	 *
	 * @return the starthotelday
	 */
	public String getStarthotelday() {
		return starthotelday;
	}

	/**
	 * Sets the starthotelday.
	 *
	 * @param starthotelday the new starthotelday
	 */
	public void setStarthotelday(String starthotelday) {
		this.starthotelday = starthotelday;
	}

	/**
	 * Gets the starthotelmonth.
	 *
	 * @return the starthotelmonth
	 */
	public String getStarthotelmonth() {
		return starthotelmonth;
	}

	/**
	 * Sets the starthotelmonth.
	 *
	 * @param starthotelmonth the new starthotelmonth
	 */
	public void setStarthotelmonth(String starthotelmonth) {
		this.starthotelmonth = starthotelmonth;
	}

	/**
	 * Gets the starthotelyear.
	 *
	 * @return the starthotelyear
	 */
	public String getStarthotelyear() {
		return starthotelyear;
	}

	/**
	 * Sets the starthotelyear.
	 *
	 * @param starthotelyear the new starthotelyear
	 */
	public void setStarthotelyear(String starthotelyear) {
		this.starthotelyear = starthotelyear;
	}

	/**
	 * Gets the finishhotelday.
	 *
	 * @return the finishhotelday
	 */
	public String getFinishhotelday() {
		return finishhotelday;
	}

	/**
	 * Sets the finishhotelday.
	 *
	 * @param finishhotelday the new finishhotelday
	 */
	public void setFinishhotelday(String finishhotelday) {
		this.finishhotelday = finishhotelday;
	}

	/**
	 * Gets the finishhotelmonth.
	 *
	 * @return the finishhotelmonth
	 */
	public String getFinishhotelmonth() {
		return finishhotelmonth;
	}

	/**
	 * Sets the finishhotelmonth.
	 *
	 * @param finishhotelmonth the new finishhotelmonth
	 */
	public void setFinishhotelmonth(String finishhotelmonth) {
		this.finishhotelmonth = finishhotelmonth;
	}

	/**
	 * Gets the finishhotelyear.
	 *
	 * @return the finishhotelyear
	 */
	public String getFinishhotelyear() {
		return finishhotelyear;
	}

	/**
	 * Sets the finishhotelyear.
	 *
	 * @param finishhotelyear the new finishhotelyear
	 */
	public void setFinishhotelyear(String finishhotelyear) {
		this.finishhotelyear = finishhotelyear;
	}

}
