package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents a card.
 */

public class Card {

  private valueOfCards cardValue;
  private SuitsofCards rankofCard;

  /**
   * Constructs a card with the number value of the card and the suit of the card.
   *
   * @param cardValue  number value of the card
   * @param rankofCard Suit of card
   */
  public Card(valueOfCards cardValue, SuitsofCards rankofCard) {
    this.cardValue = cardValue;
    this.rankofCard = rankofCard;

  }


  /**
   * Method returns the number of the Card.
   *
   * @return numberOfCard
   */
  public int getNumberOfCard() {
    return cardValue.intValue;
  }


  public SuitsofCards getRankofCard() {
    return rankofCard;
  }

  //override equality

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return cardValue == card.cardValue
        && rankofCard == card.rankofCard;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardValue, rankofCard);
  }

  /*
  A to string method that creates the suit and the value

   */
  @Override
  public String toString() {
    if (this == null) {
      return ".  ";
    }
    return cardValue.toString() + rankofCard.toString();
  }
}

