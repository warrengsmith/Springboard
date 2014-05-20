package com.wgs.example;

import static org.junit.Assert.assertEquals;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

/**
 * The Class TestClassUsingInterfaceImplementationWithJMockitProxy.
 * @author Warren Smith
 * @version 1.0
 */
public class TestClassUsingInterfaceImplementationWithJMockitProxy {

	/**
	 * Test execute with interface proxy mock up.
	 */
	@Test
	public void testExecuteWithInterfaceProxyMockUp() {
		// Anonymous inner class interface proxy to provide the fake implementation of interface method
		IManipulator manipulator = new MockUp<IManipulator>() {
			/**
			 * Manipulate.
			 *
			 * @param string the string
			 */
			@Mock
			public void manipulate(final String string){
				assertEquals("InterfaceProxy",string);
				System.out.println("In InInterfaceProxyManipulator - " + string);
			}
		}.getMockInstance();
		
		// Instantiate the class under test and execute the code
		final ClassUsingInterfaceImplementation classUsingInterfaceImplementation = new ClassUsingInterfaceImplementation();
		classUsingInterfaceImplementation.execute(manipulator, "InterfaceProxy");
	}

}
