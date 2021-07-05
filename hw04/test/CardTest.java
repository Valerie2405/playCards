import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class to represent the test.
 */
public class CardTest {

  //Example of Card: numberOfCard, rankofCard
  Card card1 = new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS);
  Card card2 = new Card(valueOfCards.TWO, SuitsofCards.CLUBS);
  Card card3 = new Card(valueOfCards.THREE, SuitsofCards.SPADES);
  Card card4 = new Card(valueOfCards.FOUR, SuitsofCards.HEARTS);
  Card card4a = new Card(valueOfCards.FIVE, SuitsofCards.HEARTS);
  Card card4b = new Card(valueOfCards.FOUR, SuitsofCards.HEARTS);

  //TESTING

  //getNumberOfCard test: test to ensure the number value of the card is returned
  @Test
  public void testgetNumberOfCard() {
    assertEquals(1, card1.getNumberOfCard());
    assertEquals(2, card2.getNumberOfCard());
  }

  //setNumberOfCards test: test to ensure the Suit of the card is returned
  @Test
  public void testgetRankofCard() {
    assertEquals(SuitsofCards.CLUBS, card2.getRankofCard());
  }

  //Equality test: test to ensure the cards are equal
  @Test
  public void testequals() {
    assertFalse(card4a.equals(card4));
    assertEquals(true, card4b.equals(card4));
  }

  //HashCode test: test to ensure the cards are equal
  @Test
  public void voidtesthashCode() {
    assertTrue(card4b.hashCode() == card4.hashCode());
    assertFalse(card3.hashCode() == card2.hashCode());
  }


}
