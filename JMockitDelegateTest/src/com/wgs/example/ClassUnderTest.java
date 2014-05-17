package com.wgs.example;

/**
 * The Class ClassUnderTest.
 * @author Warren Smith
 * @version 1.0S
 */
public class ClassUnderTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final ClassUnderTest classUnderTest = new ClassUnderTest();
		classUnderTest.execute("test");
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
