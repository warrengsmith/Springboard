package com.wgs.example;

import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

/**
 * The Class MockUpTest.
 */
public class MockUpTest {

	/**
	 * The Class MockStaticManipulator.
	 */
	public final class MockStaticManipulator extends MockUp<StaticManipulator> {
		
		/**
		 * Manipulate.
		 *
		 * @param string the string
		 */
		@Mock
		public void manipulate(String string){
			assertEquals("test",string);
			System.out.println("In MockStaticManipulator - " + string);
		}
	}
	

	/**
	 * Test execute with mock static manipulator.
	 */
	@Test
	public void testExecuteWithMockStaticManipulator() {
		new MockStaticManipulator();
		ClassUnderTest2 classUnderTest2 = new ClassUnderTest2();
		classUnderTest2.execute("test");
	}

}
