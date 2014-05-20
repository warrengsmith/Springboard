package com.wgs.example.statik;


/**
 * The ClassUsingStaticMethodImplementation.
 * @author Warren Smith
 * @version 1.0
 */
public class ClassUsingStaticMethodImplementation {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final ClassUsingStaticMethodImplementation classUnderTest = new ClassUsingStaticMethodImplementation();
		classUnderTest.execute("ClassUsingStaticMethodImplementation");
	}

	/**
	 * Execute.
	 *
	 * @param string
	 *            the string
	 */
	public void execute(final String string) {
		StaticManipulator.manipulate(string);
		System.out.println("Back in execute()");
	}
}
