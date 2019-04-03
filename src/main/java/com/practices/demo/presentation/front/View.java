package com.practices.demo.presentation.front;

/**
 * The Class View.
 */
public class View {
	
	/** The Constant REDIRECT_PREFIX. */
	public static final String REDIRECT_PREFIX = "redirect:";
	
	/** The Constant HOME_VIEW. */
	public static final String HOME_VIEW = "home";

	/** The Constant NEW_HOME. */
	public static final String NEW_PERSON_VIEW = "new";
	
	/**
	 * Instantiates a new view.
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
