package cs3500.pyramidsolitaire.model.hw02;

/**
 * Suits of Cards.
 */
public enum SuitsofCards {

  /**
   * CLUBS suitsofCards.
   */
  CLUBS("♣"),
  /**
   * DIAMONDS SuitsofCards.
   */
  DIAMONDS("♦"),
  /**
   * HEARTS SuitsofCards.
   */
  HEARTS("♥"),
  /**
   * SPADES SuitsofCards.
   */
  SPADES("♠");


  String stringValue;

  //constructor of enum
  SuitsofCards(String str) {

    stringValue = str;

  }

  //Override to string: returns stringvalue of enum
  @Override
  public String toString() {
    return stringValue;
  }

}
