package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

/**
 * The Class KnightAopMainAspectTest.
 */
public class KnightAopMainAspectTest {
			
	/** The minstrel. */
	@Mocked Minstrel minstrel;
		
	/**
	 * Method Minstrel sings before and after quest test.
	 */
	@Test
	public void MinstrelSingsBeforeAndAfterQuestTest() {
		new Expectations() {
			{
				new Minstrel(); 
				minstrel.singBeforeQuest(); 
				minstrel.singAfterQuest();
			}
		};
		KnightAopMain.main(null);
	}
}
