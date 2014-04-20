package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

/**
 * The Class BraveKnightTest.
 */
public class BraveKnightTest {

	/** The quest. */
	@Mocked Quest quest;
	
	/**
	 * Method Knight should embark on quest.
	 *
	 * @throws QuestException the quest exception
	 */
	@Test
  public void knightShouldEmbarkOnQuest() throws QuestException {
	  new Expectations() {
		  {
			  quest.embark(); times = 1;
		  }
	  };
	  BraveKnight knight = new BraveKnight(quest); 
	  knight.embarkOnQuest();
  }
}
