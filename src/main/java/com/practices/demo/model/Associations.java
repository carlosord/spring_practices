package com.practices.demo.model;

/**
 * The Class Associations.
 */
public class Associations {

	/**
	 * The Class ReserveHotel.
	 */
	public static class ReserveHotel {

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

		/*
		 * Method link person and car
		 *
		 * @param person
		 *
		 * @param car
		 *
		 */
		public static void link(ReserveCarDate reserve, Car car) {

			car.getReserveCarDates().add(reserve);
			reserve.setCar(car);
		}

		/*
		 * Method unlink person and car
		 *
		 * @param person
		 *
		 * @param car
		 *
		 */
		public static void unlink(ReserveCarDate reserve, Car car) {

			car.getReserveCarDates().remove(reserve);
			reserve.setCar(null);

		}
	}

}
