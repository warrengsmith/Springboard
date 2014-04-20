package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class KnightMainTest.
 */
public class KnightMainTest {

	/** The context. */
	@Mocked ClassPathXmlApplicationContext context;
	
	/** The knight. */
	@Mocked Knight knight;
	
	/**
	 * Method Test.
	 */
	@Test
	public void test() {
		new Expectations() {
			{
				new ClassPathXmlApplicationContext("knights.xml"); result = context;
				context.getBean("knight"); result = knight;
				knight.embarkOnQuest();
				context.close();
			}
		};
		KnightMain.main(null);
	}
}
