package com.practices.demo.dto;

public class HotelDto {

	/** The id. */
	private Long id;

	/** The code. */
	private String code;

	/** The name of hotel. */
	private String name;

	/** The location. */
	private String location;

	/** The total bedrooms. */
	private int totalbedrooms;

	/** The occupied bedrooms. */
	private int occupiedbedrooms;

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
	 * Gets the code.
	 *
	 * @return the code
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
	 * Gets totalbedrooms.
	 *
	 * @return totalbedrooms
	 */
	public int getTotalbedrooms() {
		return totalbedrooms;
	}

	/**
	 * Sets totalbedrooms.
	 *
	 * @param totalbedrooms the new totalbedrooms
	 */
	public void setTotalbedrooms(int totalbedrooms) {
		this.totalbedrooms = totalbedrooms;
	}

	/**
	 * Gets occupiedbedrooms.
	 *
	 * @return occupiedbedrooms
	 */
	public int getOccupiedbedrooms() {
		return occupiedbedrooms;
	}

	/**
	 * Sets occupiedbedrooms.
	 *
	 * @param occupiedbedrooms the new occupiedbedrooms
	 */
	public void setOccupiedbedrooms(int occupiedbedrooms) {
		this.occupiedbedrooms = occupiedbedrooms;
	}

}
