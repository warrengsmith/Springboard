package com.springinaction.knights;

import java.io.PrintStream;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

/**
 * The Class MakeRoundTableRounderQuestTest.
 */
public class MakeRoundTableRounderQuestTest {

	/** The print stream. */
	@Mocked PrintStream printStream;

	/**
	 * Method Make round table rounder quest test.
	 */
	@Test
	public void makeRoundTableRounderQuestTest() {
		new Expectations() {
			{
				printStream.println(anyString);
			}
		};
		Quest quest = new MakeRoundTableRounderQuest();
		quest.embark();
	}
}
