package com.practices.demo.dto;

import javax.xml.bind.annotation.XmlType;

/**
 * The Class ListHotelDto.
 */
@XmlType(namespace = "http://www.example.org/listHotel")
public class ListHotelDto {

	/** The name. */
	private String name;

	/** The location. */
	private String location;

	/** The start hotel reserve. */
	private String startHotelReserve;

	/** The finish hotel reserve. */
	private String finishHotelReserve;

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
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the start hotel reserve.
	 *
	 * @return the start hotel reserve
	 */
	public String getStartHotelReserve() {
		return startHotelReserve;
	}

	/**
	 * Sets the start hotel reserve.
	 *
	 * @param startHotelReserve the new start hotel reserve
	 */
	public void setStartHotelReserve(String startHotelReserve) {
		this.startHotelReserve = startHotelReserve;
	}

	/**
	 * Gets the finish hotel reserve.
	 *
	 * @return the finish hotel reserve
	 */
	public String getFinishHotelReserve() {
		return finishHotelReserve;
	}

	/**
	 * Sets the finish hotel reserve.
	 *
	 * @param finishHotelReserve the new finish hotel reserve
	 */
	public void setFinishHotelReserve(String finishHotelReserve) {
		this.finishHotelReserve = finishHotelReserve;
	}

}
