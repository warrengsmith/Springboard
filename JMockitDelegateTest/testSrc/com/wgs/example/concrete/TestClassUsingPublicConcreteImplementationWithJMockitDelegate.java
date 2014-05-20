package com.wgs.example.concrete;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import com.wgs.example.concrete.ClassUsingPublicConcreteImplementation;
import com.wgs.example.concrete.Manipulator;

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
	final ClassUsingPublicConcreteImplementation classUnderTest = new ClassUsingPublicConcreteImplementation();
	classUnderTest.execute("ClassUsingPublicConcreteImplentationDelegateTest");
	}
}
