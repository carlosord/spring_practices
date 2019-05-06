package com.practices.demo.model;

public class Associations {

	public static class Book { //Cambiar link de coche

		/*
		 * Method link person and hotel
		 *
		 * @param person
		 *
		 * @param hotel
		 *
		 */
		public static void linkHotel(Person person, Hotel hotel) {

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
		public static void unlinkHotel(Person person, Hotel hotel) {

			person._getHotel().remove(hotel);
			hotel._getPerson().remove(person);
		}


		/*
		 * Method link person and car
		 *
		 * @param person
		 *
		 * @param car
		 *
		 */
		public static void linkCar (Person person, Car car) {

			car.setPerson(person);
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
		public static void unlinkCar(Person person, Car car) {

			person._getCar().remove(car);
			car.setPerson(null);
		}



	}

}
