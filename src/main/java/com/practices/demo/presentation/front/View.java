package com.practices.demo.presentation.front;

/**
 * The Class View.
 */
public class View {

	/** The Constant REDIRECT_PREFIX. */
	public static final String REDIRECT_PREFIX = "redirect:";

	/** The Constant HOME_VIEW. */
	public static final String HOME_VIEW = "home";

	/** The Constant NEW_PERSON_VIEW. */
	public static final String NEW_PERSON_VIEW = "new";

	/** The Constant EDIT_PERSON_VIEW. */
	public static final String EDIT_PERSON_VIEW = "edit";

	/** The Constant NEW_CAR_VIEW. */
	public static final String CAR_VIEW = "car";


	/**
	 * Private constructor.
	 */
	private View() {}

	/**
	 * Redirect.
	 *
	 * @param view the view
	 * @return the string
	 */
	public static String redirect(String view) {
		return String.join("/", REDIRECT_PREFIX, view);
	}

}
