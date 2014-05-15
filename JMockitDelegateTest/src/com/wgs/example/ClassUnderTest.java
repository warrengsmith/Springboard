package com.wgs.example;

/**
 * The Class ClassUnderTest.
 * @author Warren Smith
 */
public class ClassUnderTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ClassUnderTest classUnderTest = new ClassUnderTest();
		classUnderTest.execute("test");
	}

	/**
	 * Execute.
	 *
	 * @param string the string
	 */
	public void execute(String string) {
		Manipulator manipulator = new Manipulator();
		System.out.println(manipulator.manipulate(string));
	}
}
