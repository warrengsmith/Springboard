package com.springinaction.knights;

public class BraveKnight implements Knight {
 
  private final transient Quest quest;
  
  public BraveKnight(final Quest quest) {
    this.quest = quest;      
  }
  
  public void embarkOnQuest() throws QuestException {
    quest.embark();
  }
}
