package com.wgs.example;

/**
 * The Class StaticManipulator.
 * @author Warren Smith
 * @version 1.0
 */
public final class StaticManipulator {
	
	/**
	 * Prevent instantiation of a new static manipulator.
	 */
	private StaticManipulator(){
		// Prevent instantiation
	}

	/**
	 * Manipulate.
	 *
	 * @param string the string
	 */
	public static void manipulate(final String string) {
		System.out.println("In StaticManipulator - " + string);
	}
}
