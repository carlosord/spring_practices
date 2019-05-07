package com.practices.demo.model;

public class Associations {

	public static class ReserveHotel {

		/*
		 * Method link person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void link(Person person, Hotel hotel) {

			hotel._getPerson().add(person);
			person._getHotel().add(hotel);

		}

		/*
		 * Method unlink person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void unlink(Person person, Hotel hotel) {

			person._getHotel().remove(hotel);
			hotel._getPerson().remove(person);
		}

	}

	public static class ReserveCar {

		/*
		 * Method link person and car
		 *
		 * @param person
		 *
		 * @param car
		 *
		 */
		public static void link(Person person, Car car) {

			car._getPerson().add(person);
			person._getCar().add(car);

		}

		/*
		 * Method unlink person and car
		 *
		 * @param person
		 *
		 * @param car
		 *
		 */
		public static void unlink(Person person, Car car) {

			person._getCar().remove(car);
			car._getPerson().remove(person);
		}
	}

}
