package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

/**
 * The Class DamselRescuingKnightTest.
 */
public class DamselRescuingKnightTest {

	/** The rescue damsel quest. */
	@Mocked RescueDamselQuest rescueDamselQuest;
	
	/**
	 * Method Embark on quest test.
	 */
	@Test
	public void embarkOnQuestTest() {
		new Expectations() {
			{
				new RescueDamselQuest(); 
				rescueDamselQuest.embark(); times = 1;
			}
		};
		DamselRescuingKnight damselRescuingKnight = new DamselRescuingKnight();
		damselRescuingKnight.embarkOnQuest();
	}
}
