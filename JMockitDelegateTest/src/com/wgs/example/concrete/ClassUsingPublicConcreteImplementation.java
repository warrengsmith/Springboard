package com.wgs.example.concrete;


/**
 * The ClassUsingPublicConcreteImplementation.
 * @author Warren Smith
 * @version 1.0
 */
public class ClassUsingPublicConcreteImplementation {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final ClassUsingPublicConcreteImplementation classUnderTest = new ClassUsingPublicConcreteImplementation();
		classUnderTest.execute("ClassUsingPublicConcreteImplementation");
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
