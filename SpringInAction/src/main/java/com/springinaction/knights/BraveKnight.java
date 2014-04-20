package com.springinaction.knights;

/**
 * The Class BraveKnight.
 */
public class BraveKnight implements Knight {
 
  /** The quest. */
  private final transient Quest quest;
  
  /**
   * Constructor instantiates a new brave knight.
   *
   * @param quest the quest
   */
  public BraveKnight(final Quest quest) {
    this.quest = quest;      
  }
  
  /* (non-Javadoc)
   * @see com.springinaction.knights.Knight#embarkOnQuest()
   */
  public void embarkOnQuest() throws QuestException {
    quest.embark();
  }
}
