package com.wgs.example;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

/**
 * The Class TestClassUsingPublicConcreteImplementationWithJMockitDelegate.
 * @author Warren Smith
 * @version 1.0
 */
public class TestClassUsingPublicConcreteImplementationWithJMockitDelegate {

	/**
	 * Test execute delegate.
	 *
	 * @param manipulator the manipulator
	 */
	@Test
	public void testExecuteDelegate(@Mocked final Manipulator manipulator) {
		new Expectations() {
			{
				new Manipulator();
				manipulator.manipulate("ClassUsingPublicConcreteImplentationDelegateTest");
				result = new Delegate() {
					@SuppressWarnings("unused")
					String delegateManipulate(final String string) {
						return "Delegated - " + string;
					}
				};
			}
		};
	final ClassUsingPublicConcreteImplentation classUnderTest = new ClassUsingPublicConcreteImplentation();
	classUnderTest.execute("ClassUsingPublicConcreteImplentationDelegateTest");
	}
}
