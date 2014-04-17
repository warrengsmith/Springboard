package com.springinaction.knights;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

public class BraveKnightTest {

	@Mocked Quest quest;
	
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
