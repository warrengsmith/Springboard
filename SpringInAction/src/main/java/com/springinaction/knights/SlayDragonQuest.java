package com.springinaction.knights;

/**
 * The Class SlayDragonQuest.
 */
public class SlayDragonQuest implements Quest {

  /* (non-Javadoc)
   * @see com.springinaction.knights.Quest#embark()
   */
  public void embark() throws QuestException {
    System.out.println("Slaying Dragon!");
  }

}
