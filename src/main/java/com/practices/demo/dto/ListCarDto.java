package com.practices.demo.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * The Class ListCarDto.
 */
@XmlType(namespace = "http://www.example.org/listCar")
public class ListCarDto {

	/** The license. */
	@XmlAttribute
	private String license;

	/** The colour. */
	@XmlAttribute
	private String colour;

	/** The start car reserve. */
	private String startCarReserve;

	/** The finish car reserve. */
	private String finishCarReserve;

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
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the new colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Gets the start car reserve.
	 *
	 * @return the start car reserve
	 */
	public String getStartCarReserve() {
		return startCarReserve;
	}

	/**
	 * Sets the start car reserve.
	 *
	 * @param startCarReserve the new start car reserve
	 */
	public void setStartCarReserve(String startCarReserve) {
		this.startCarReserve = startCarReserve;
	}

	/**
	 * Gets the finish car reserve.
	 *
	 * @return the finish car reserve
	 */
	public String getFinishCarReserve() {
		return finishCarReserve;
	}

	/**
	 * Sets the finish car reserve.
	 *
	 * @param finishCarReserve the new finish car reserve
	 */
	public void setFinishCarReserve(String finishCarReserve) {
		this.finishCarReserve = finishCarReserve;
	}

}
