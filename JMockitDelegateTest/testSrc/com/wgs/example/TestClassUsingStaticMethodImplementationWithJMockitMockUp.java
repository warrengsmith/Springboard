package com.wgs.example;

import static org.junit.Assert.assertEquals;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

/**
 * The Class TestClassUsingStaticMethodImplementationWithJMockitMockUp.
 * @author Warren Smith
 * @version 1.0
 */
public class TestClassUsingStaticMethodImplementationWithJMockitMockUp {

	/**
	 * The Class MockStaticManipulator. This class could be top-level. 
	 * That would be useful if the mock class is to be reused in multiple test classes.
	 */
	public final class MockStaticManipulator extends MockUp<StaticManipulator> {
		
		/**
		 * Manipulate.
		 *
		 * @param string the string
		 */
		@Mock
		public void manipulate(final String string){
			assertEquals("testExecuteWithMockStaticManipulator",string);
			System.out.println("In MockStaticManipulator - " + string);
		}
	}
	
	/**
	 * Test execute with no mock implemented. This is not a real JUnit test,
	 * but serves to demonstrate the code running with no fake mock implementations.
	 */
	@Test
	public void testExecuteWithNoMockImplemented() {
		// Instantiate the class under test and execute the code.
		final ClassUsingStaticMethodImplementation classUsingStaticMethodImplementation = new ClassUsingStaticMethodImplementation();
		classUsingStaticMethodImplementation.execute("ClassUsingPublicConcreteImplentation");
	}
	
	/**
	 * Test execute with mock static manipulator defined as inner class in this test class.
	 */
	@Test
	public void testExecuteWithMockStaticManipulator() {
		// Setting up the fake mock to replace StaticManipulator in this test.
		new MockStaticManipulator();
		
		// Instantiate the class under test and execute the code.
		final ClassUsingStaticMethodImplementation classUsingStaticMethodImplementation = new ClassUsingStaticMethodImplementation();
		classUsingStaticMethodImplementation.execute("testExecuteWithMockStaticManipulator");
	}
	
	/**
	 * Test execute with mock static manipulator in line anonymous mock up instead of the 
	 * implementation provided in the inner class.
	 */
	@Test
	public void testExecuteWithMockStaticManipulatorInLineAnonymousMockUp() {
		// Anonymous inner class to provide the fake implementation  of StaticManipulator
		new MockUp<StaticManipulator>() {
			/**
			 * Manipulate.
			 *
			 * @param string the string
			 */
			@Mock
			public void manipulate(final String string){
				assertEquals("testExecuteWithMockStaticManipulatorInLineAnonymousMockUp",string);
				System.out.println("In InLineAnonymousMockStaticManipulator - " + string);
			}
		};
		
		// Instantiate the class under test and execute the code
		final ClassUsingStaticMethodImplementation classUsingStaticMethodImplementation = new ClassUsingStaticMethodImplementation();
		classUsingStaticMethodImplementation.execute("testExecuteWithMockStaticManipulatorInLineAnonymousMockUp");
	}

}
