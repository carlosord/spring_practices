package com.practices.demo.model;

/**
 * The Class Associations.
 */
public class Associations {

	/**
	 * The Class ReserveHotel.
	 */
	public static class ReserveHotel {

		/**
		 * Link.
		 *
		 * @param reserve the reserve
		 * @param hotel   the hotel
		 */
		/*
		 * Method link person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void link(ReserveHotelDate reserve, Hotel hotel) {

			hotel.getReserveHotel().add(reserve);
			reserve.setHotel(hotel);

		}

		/**
		 * Unlink.
		 *
		 * @param reserve the reserve
		 * @param hotel   the hotel
		 */
		/*
		 * Method unlink person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void unlink(ReserveHotelDate reserve, Hotel hotel) {

			hotel.getReserveHotel().remove(reserve);
			reserve.setHotel(null);
		}

	}

	/**
	 * The Class ReserveCar.
	 */
	public static class ReserveCar {

		/**
		 * Link.
		 *
		 * @param reserve the reserve
		 * @param car     the car
		 * @param person  the person
		 */
		public static void link(ReserveCarDate reserve, Car car, Person person) {

			car.getReserveCarDates().add(reserve);
			reserve.setCar(car);

			person.getReserveCarDates().add(reserve);
			reserve.setPerson(person);
		}

		/**
		 * Unlink.
		 *
		 * @param reserve the reserve
		 * @param car     the car
		 * @param person  the person
		 */
		public static void unlink(ReserveCarDate reserve, Car car, Person person) {

			car.getReserveCarDates().remove(reserve);
			reserve.setCar(null);

			person.getReserveCarDates().remove(reserve);
			reserve.setPerson(null);

		}
	}

}
