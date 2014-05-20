package com.wgs.example;

/**
 * The ClassUsingPublicConcreteImplentation.
 * @author Warren Smith
 * @version 1.0
 */
public class ClassUsingPublicConcreteImplentation {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final ClassUsingPublicConcreteImplentation classUnderTest = new ClassUsingPublicConcreteImplentation();
		classUnderTest.execute("ClassUsingPublicConcreteImplentation");
	}

	/**
	 * Execute.
	 *
	 * @param string the string
	 */
	public void execute(final String string) {
		final Manipulator manipulator = new Manipulator();
		System.out.println(manipulator.manipulate(string));
	}
}
