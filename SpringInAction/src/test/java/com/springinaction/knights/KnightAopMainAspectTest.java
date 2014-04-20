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
	
	@Mocked SlayDragonQuest quest;
		
	/**
	 * Method Minstrel sings before and after quest test.
	 */
	@Test
	public void MinstrelSingsBeforeAndAfterQuestTest() {
		new Expectations() {
			{
				new Minstrel(); 
				minstrel.singBeforeQuest(); 
				quest.embark();
				minstrel.singAfterQuest();
			}
		};
		KnightAopMain.main(null);
	}
}
