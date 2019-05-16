package com.practices.demo.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.practices.demo.model.Hotel;
import com.practices.demo.model.Car;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveCar;
import com.practices.demo.model.ReserveHotel;

/**
 * The Class DtoAssembler.
 */
public class DtoAssembler {

	/** The format. */
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the person
	 */
	public static Person toEntity(PersonDto dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setDni(dto.getDni());
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		try {
			entity.setBirthday(format.parse(dto.getBirthday()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		entity.setGender(dto.getGender());
		return entity;
	}

	/**
	 * From entity.
	 *
	 * @param entity the entity
	 * @return the person dto
	 */
	public static PersonDto fromEntity(Person entity) {
		PersonDto dto = new PersonDto();
		dto.setId(entity.getId());
		dto.setDni(entity.getDni());
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		if (entity.getBirthday() != null) {
			dto.setBirthday(format.format(entity.getBirthday()));
			dto.setAge((int) ChronoUnit.YEARS.between(
					Instant.ofEpochMilli(entity.getBirthday().getTime()).atZone(ZoneId.systemDefault()).toLocalDate(),
					LocalDate.now()));
		}
		dto.setGender(entity.getGender());
		dto.setHascar(entity.hasCar(entity));
		dto.setHashotel(entity.hasHotel(entity));

		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the hotel
	 */
	public static Hotel toEntity(HotelDto dto) {

		Hotel entity = new Hotel();

		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setLocation(dto.getLocation());
		entity.setTotalbedrooms(dto.getTotalbedrooms());
		entity.setOccupiedbedrooms(dto.getOccupiedbedrooms());

		return entity;
	}

	/**
	 * From entity.
	 *
	 * @param entity the entity
	 * @return the hotel dto
	 */
	public static HotelDto fromEntity(Hotel entity) {

		HotelDto dto = new HotelDto();

		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setLocation(entity.getLocation());
		dto.setTotalbedrooms(entity.getTotalbedrooms());
		dto.setOccupiedbedrooms(entity.getOccupiedbedrooms());

		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the car
	 */
	public static Car toEntity(CarDto dto) {
		Car entity = new Car();
		entity.setLicense(dto.getLicense());
		entity.setColour(dto.getColour());
		entity.setNumberofcardoors(dto.getNumberofcadoors());

		return entity;
	}

	/**
	 * From entity.
	 *
	 * @param entity the entity
	 * @return the car dto
	 */
	public static CarDto fromEntity(Car entity) {
		CarDto dto = new CarDto();
		dto.setLicense(entity.getLicense());
		dto.setColour(entity.getColour());
		dto.setNumberofcadoors(entity.getNumberofcardoors());
		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the reserve car
	 */
	public static ReserveCar toEntity(CarReserveDto dto) {
		ReserveCar entity = new ReserveCar();

		Person p = new Person();
		p.setDni(dto.getDni());
		entity.setPerson(p);

		Car c = new Car();
		c.setLicense(dto.getLicense());
		entity.setCar(c);

		try {
			entity.setStartReserve(format.parse(dto.getStartCarReserve()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			entity.setFinishReserve(format.parse(dto.getFinishCarReserve()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * From entity.
	 *
	 * @param entity the entity
	 * @return the car reserve dto
	 */
	public static CarReserveDto fromEntity(ReserveCar entity) {
		CarReserveDto dto = new CarReserveDto();

		dto.setStartCarReserve(format.format(entity.getStartReserve()));
		dto.setFinishCarReserve(format.format(entity.getFinishReserve()));

		return dto;
	}


	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the reserve hotel
	 */
	public static ReserveHotel toEntity(ReserveHotelDto dto) {
		ReserveHotel entity = new ReserveHotel();

		Person p = new Person();
		p.setDni(dto.getDni());
		entity.setPerson(p);

		Hotel h = new Hotel();
		h.setCode(dto.getCode());
		entity.setHotel(h);

		try {
			entity.setStartReserve(format.parse(dto.getStartHotelReserve()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			entity.setFinishReserve(format.parse(dto.getFinishHotelReserve()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * From entity.
	 *
	 * @param entity the entity
	 * @return the reserve hotel dto
	 */
	public static ReserveHotelDto fromEntity(ReserveHotel entity) {
		ReserveHotelDto dto = new ReserveHotelDto();

		dto.setStartHotelReserve(format.format(entity.getStartReserve()));
		dto.setFinishHotelReserve(format.format(entity.getFinishReserve()));


		return dto;
	}


	public static ListHotelDto fromListEntity(ReserveHotel entity) {
		ListHotelDto dto = new ListHotelDto();

		dto.setName(entity.getHotel().getName());
		dto.setLocation(entity.getHotel().getLocation());
		dto.setStartHotelReserve(format.format(entity.getStartReserve()));
		dto.setFinishHotelReserve(format.format(entity.getFinishReserve()));

		return dto;
	}

	public static ListCarDto fromListEntity(ReserveCar entity) {
		ListCarDto dto = new ListCarDto();

		dto.setLicense(entity.getCar().getLicense());
		dto.setColour(entity.getCar().getColour());
		dto.setStartCarReserve(format.format(entity.getStartReserve()));
		dto.setFinishCarReserve(format.format(entity.getFinishReserve()));

		return dto;
	}

}