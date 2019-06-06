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

	/** The Constant HOME_URL. */
	public static final String HOTEL_URL = "/hotel";

	/** The Constant CAR_URL. */
	public static final String CAR_URL = "/car";

	/** The Constant MODEL_URL. */
	public static final String INFOPERSON_URL = "/infoperson";

	/** The Constant PDF_URL. */
	public static final String PDF_URL = "/pdf";

	/** The Constant LASTWEEK_RESERVES_URL. */
	public static final String LASTWEEK_RESERVES_HOTEL_URL = "/lastweekhotelreserves";

	/** The Constant LASTWEEK_RESERVES_URL. */
	public static final String RESERVES_HOTEL_URL = "/reservehotel";

	/** The Constant LASTWEEK_RESERVES_CAR_URL. */
	public static final String LASTWEEK_RESERVES_CAR_URL = "/lastweekreservescar";

	/** The Constant RESERVES_PERSON_URL. */
	public static final String RESERVES_PERSON_URL = "/reservesperson";

	/**
	 * Private constructor.
	 */
	private Url() {
	}

	/**
	 * Adds the parmameters.
	 *
	 * @param view   the view
	 * @param params the params
	 * @return the string
	 */
	public static String addParmameters(String view, String... params) {
		return String.join("/", view, String.join("/", params));
	}

}
