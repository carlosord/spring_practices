package com.practices.demo.presentation.front;

/**
 * The Class Url.
 */
public class Url {

	/** The Constant HOME_URL. */
	public static final String HOME_URL = "/home";

	/** The Constant NEW_PERSON_URL. */
	public static final String NEW_PERSON_URL = "/new";

	/** The Constant EDIT_PERSON_URL. */
	public static final String EDIT_PERSON_URL = "/edit";

	/** The Constant DELETE_PERSON_URL. */
	public static final String DELETE_PERSON_URL = "/delete";

	/** The Constant CAR_URL.  */
	public static final String CAR_URL = "/car";

	/**
	 * Private constructor.
	 */
	private Url() {}

	/**
	 * Adds the parmameters.
	 *
	 * @param view the view
	 * @param params the params
	 * @return the string
	 */
	public static String addParmameters(String view, String... params) {
		return String.join("/", view, String.join("/", params));
	}

}
