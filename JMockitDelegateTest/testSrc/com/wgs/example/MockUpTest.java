package com.wgs.example;

import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

/**
 * The Class MockUpTest.
 * @author Warren Smith
 * @version 1.0
 */
public class MockUpTest {

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
		public void manipulate(String string){
			assertEquals("test2",string);
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
		ClassUnderTest2 classUnderTest2 = new ClassUnderTest2();
		classUnderTest2.execute("test1");
	}
	
	/**
	 * Test execute with mock static manipulator defined as inner class in this test class.
	 */
	@Test
	public void testExecuteWithMockStaticManipulator() {
		// Setting up the fake mock to replace StaticManipulator in this test.
		new MockStaticManipulator();
		
		// Instantiate the class under test and execute the code.
		ClassUnderTest2 classUnderTest2 = new ClassUnderTest2();
		classUnderTest2.execute("test2");
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
			public void manipulate(String string){
				assertEquals("test3",string);
				System.out.println("In InLineAnonymousMockStaticManipulator - " + string);
			}
		};
		
		// Instantiate the class under test and execute the code
		ClassUnderTest2 classUnderTest2 = new ClassUnderTest2();
		classUnderTest2.execute("test3");
	}

}
