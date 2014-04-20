package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class KnightAopMainTest.
 */
public class KnightAopMainTest {
	
	/** The context. */
	@Mocked ClassPathXmlApplicationContext context;
	
	/** The knight. */
	@Mocked Knight knight;

	/**
	 * Method Embark on quest test.
	 */
	@Test
	public void embarkOnQuestTest() {
		new Expectations() {
			{
				new ClassPathXmlApplicationContext("knights-aop.xml"); result = context;
				context.getBean("knight"); result = knight;
				knight.embarkOnQuest();
				context.close();
			}
		};
		KnightAopMain.main(null);
	}
}
