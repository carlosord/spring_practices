package com.practices.demo.model.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The Enum Gender.
 */
public enum Gender {

	/** The male. */
	MALE, 
	/** The female. */
	FEMALE;
	
	/**
	 * Gets the random gender.
	 *
	 * @return the random gender
	 */
	public static Gender getRandomGender() {
		
		List<Gender> genders = Arrays.asList(values());
		
		return genders.get(new Random().nextInt(values().length));
		
	}
	
}