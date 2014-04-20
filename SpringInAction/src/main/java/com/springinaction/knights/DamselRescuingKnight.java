package com.springinaction.knights;

/**
 * The Class DamselRescuingKnight.
 */
public class DamselRescuingKnight implements Knight {

	/** The quest. */
	private final transient RescueDamselQuest quest;

	/**
	 * Constructor instantiates a new damsel rescuing knight.
	 */
	public DamselRescuingKnight() {
		quest = new RescueDamselQuest(); 
	}

	/* (non-Javadoc)
	 * @see com.springinaction.knights.Knight#embarkOnQuest()
	 */
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}
}
