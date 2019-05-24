package com.practices.demo.model.types;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Gender.
 */
public enum Gender {

	 /** The m. */
 	M("MALE"), /** The f. */
 F("FEMALE");

    /** The value. */
    private final String value;

    /** The Constant values. */
    private static final Map<String, Gender> values = new HashMap<String, Gender>();
    static {
        for (Gender g : Gender.values()) {
            if (values.put(g.value, g) != null) {
                  throw new IllegalArgumentException("duplicate value: " + g.value);
            }
        }
    }

    /**
     * Instantiates a new gender.
     *
     * @param option the option
     */
    private Gender(String option) {
          value = option;
    }

    /**
     * From string.
     *
     * @param option the option
     * @return the gender
     */
    public static Gender fromString(String option) {
        return values.get(option);
    }

}