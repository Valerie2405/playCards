package cs3500.pyramidsolitaire.model.hw02;

/**
 * value of cards.
 */
public enum valueOfCards {
  /**
   * ace valueOfCards.
   */
  ACE("A", 1),
  /**
   * two valueOfCards.
   */
  TWO("2", 2),
  /**
   * three valueOfCards.
   */
  THREE("3", 3),
  /**
   * four valueOfCards.
   */
  FOUR("4", 4),
  /**
   * five valueOfCards.
   */
  FIVE("5", 5),
  /**
   * six valueOfCards.
   */
  SIX("6", 6),
  /**
   * seven valueOfCards.
   */
  SEVEN("7", 7),
  /**
   * eight valueOfCards.
   */
  EIGHT("8", 8),
  /**
   * nine valueOfCards.
   */
  NINE("9", 9),
  /**
   * ten valueOfCards.
   */
  TEN("10", 10),
  /**
   * jack valueOfCards.
   */
  JACK("J", 11),
  /**
   * queen valueOfCards.
   */
  QUEEN("Q", 12),
  /**
   * king valueOfCards.
   */
  KING("K", 13);

  String stringValue;
  int intValue;

  //Constructor of Enum
  valueOfCards(String str, int cardNumber) {
    stringValue = str;
    intValue = cardNumber;
  }

  //Override toString: returns the string value of enum
  @Override
  public String toString() {
    return stringValue;
  }
}
