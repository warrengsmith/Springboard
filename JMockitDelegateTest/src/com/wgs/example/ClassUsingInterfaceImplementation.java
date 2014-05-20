package com.wgs.example;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassUsingInterfaceImplementation.
 * @author Warren Smith
 * @version 1.0
 */
public class ClassUsingInterfaceImplementation {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final ClassUsingInterfaceImplementation classUnderTest = new ClassUsingInterfaceImplementation();
		IManipulator manipulatorImpl = new ManipulatorImpl();
		classUnderTest.execute(manipulatorImpl, "InterfaceExecution");
	}

	/**
	 * Execute.
	 *
	 * @param manipulator the manipulator
	 * @param string the string
	 */
	public void execute(final IManipulator manipulator, final String string) {
		manipulator.manipulate(string);
		System.out.println("Back in execute()");
	}
}
