package com.springinaction.knights;

/**
 * The Class RescueDamselQuest.
 */
public class RescueDamselQuest implements Quest {
  
  /* (non-Javadoc)
   * @see com.springinaction.knights.Quest#embark()
   */
  public void embark() throws QuestException {
    System.out.println("Rescuing damsel in distress");
  }
}
