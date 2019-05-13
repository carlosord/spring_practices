package com.practices.demo.model;

/**
 * The Class Associations.
 */
public class Associations {

	/**
	 * The Class BookHotel.
	 */
	public static class BookHotel {

		/**
		 * Link.
		 *
		 * @param reserveHotel the reserve
		 * @param hotel        the hotel
		 * @param person       the person
		 */
		/*
		 * Method link person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void link(com.practices.demo.model.ReserveHotel reserveHotel, Hotel hotel, Person person) {

			hotel.getReserveHotel().add(reserveHotel);

			person.getReserveHotel().add(reserveHotel);

			reserveHotel.setHotel(hotel);
			reserveHotel.setPerson(person);

		}

		/**
		 * Unlink.
		 *
		 * @param reserve the reserve
		 * @param hotel   the hotel
		 * @param person  the person
		 */
		/*
		 * Method unlink person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void unlink(ReserveHotel reserve, Hotel hotel, Person person) {

			person.getReserveHotel().remove(reserve);
			hotel.getReserveHotel().remove(reserve);
			reserve.setHotel(null);
			reserve.setPerson(null);
		}

	}

	/**
	 * The Class BookCar.
	 */
	public static class BookCar {

		/**
		 * Link.
		 *
		 * @param reserve the reserve
		 * @param car     the car
		 * @param person  the person
		 */
		public static void link(ReserveCar reserve, Car car, Person person) {

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
		public static void unlink(ReserveCar reserve, Car car, Person person) {

			car.getReserveCarDates().remove(reserve);
			reserve.setCar(null);

			person.getReserveCarDates().remove(reserve);
			reserve.setPerson(null);

		}
	}

}
