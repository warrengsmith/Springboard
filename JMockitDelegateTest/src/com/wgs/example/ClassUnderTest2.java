package com.wgs.example;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassUnderTest2.
 * @author Warren Smith
 * @version 1.0
 */
public class ClassUnderTest2 {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ClassUnderTest2 classUnderTest = new ClassUnderTest2();
		classUnderTest.execute("test");
	}

	/**
	 * Execute.
	 *
	 * @param string
	 *            the string
	 */
	public void execute(String string) {
		StaticManipulator.manipulate(string);
		System.out.println("Back in execute()");
	}

}
