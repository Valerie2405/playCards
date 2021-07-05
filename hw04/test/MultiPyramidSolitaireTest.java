import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class.
 */
public class MultiPyramidSolitaireTest {

  MultiPyramidSolitaire model;

  @Before
  public void setUp() {
    model = new MultiPyramidSolitaire();
  }

  //EXAMPLES
  //DECK OF CARDS ( 104 CARDS)
  //EXAMPLES
  //DECK OF CARDS (52 cards)
  public ArrayList<Card> listOfCardsTest = new ArrayList<Card>(Arrays.asList(
      //DIAMONDS
      //ROW 0
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      //ROW1
      new Card(valueOfCards.TWO, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.THREE, SuitsofCards.DIAMONDS),
      //ROW2
      new Card(valueOfCards.FOUR, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
      //R3
      new Card(valueOfCards.SEVEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.EIGHT, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.NINE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TEN, SuitsofCards.DIAMONDS),
      //R4
      new Card(valueOfCards.JACK, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.QUEEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.KING, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.ACE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TWO, SuitsofCards.CLUBS),
      //R5
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      new Card(valueOfCards.FOUR, SuitsofCards.CLUBS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.SIX, SuitsofCards.CLUBS),
      new Card(valueOfCards.SEVEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.EIGHT, SuitsofCards.CLUBS),
      //R6
      new Card(valueOfCards.NINE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.JACK, SuitsofCards.CLUBS),
      new Card(valueOfCards.QUEEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.KING, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TWO, SuitsofCards.HEARTS),
      //R7
      new Card(valueOfCards.THREE, SuitsofCards.HEARTS),
      new Card(valueOfCards.FOUR, SuitsofCards.HEARTS),
      new Card(valueOfCards.FIVE, SuitsofCards.HEARTS),
      new Card(valueOfCards.SIX, SuitsofCards.HEARTS),
      new Card(valueOfCards.SEVEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.EIGHT, SuitsofCards.HEARTS),
      new Card(valueOfCards.NINE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TEN, SuitsofCards.HEARTS),
      //R8
      new Card(valueOfCards.JACK, SuitsofCards.HEARTS),
      new Card(valueOfCards.QUEEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.KING, SuitsofCards.HEARTS),
      new Card(valueOfCards.ACE, SuitsofCards.SPADES), //40th card
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.SPADES),
      new Card(valueOfCards.FOUR, SuitsofCards.SPADES),
      new Card(valueOfCards.FIVE, SuitsofCards.SPADES),
      new Card(valueOfCards.SIX, SuitsofCards.SPADES),
      //R9
      new Card(valueOfCards.SEVEN, SuitsofCards.SPADES),
      new Card(valueOfCards.EIGHT, SuitsofCards.SPADES),
      new Card(valueOfCards.NINE, SuitsofCards.SPADES),
      new Card(valueOfCards.TEN, SuitsofCards.SPADES),
      new Card(valueOfCards.JACK, SuitsofCards.SPADES),
      new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
      new Card(valueOfCards.KING, SuitsofCards.SPADES),
      //DIAMONDS
      //ROW 0
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      //ROW1
      new Card(valueOfCards.TWO, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.THREE, SuitsofCards.DIAMONDS),
      //ROW2
      new Card(valueOfCards.FOUR, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
      //R3
      new Card(valueOfCards.SEVEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.EIGHT, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.NINE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TEN, SuitsofCards.DIAMONDS),
      //R4
      new Card(valueOfCards.JACK, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.QUEEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.KING, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.ACE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TWO, SuitsofCards.CLUBS),
      //R5
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      new Card(valueOfCards.FOUR, SuitsofCards.CLUBS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.SIX, SuitsofCards.CLUBS),
      new Card(valueOfCards.SEVEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.EIGHT, SuitsofCards.CLUBS),
      //R6
      new Card(valueOfCards.NINE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.JACK, SuitsofCards.CLUBS),
      new Card(valueOfCards.QUEEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.KING, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TWO, SuitsofCards.HEARTS),
      //R7
      new Card(valueOfCards.THREE, SuitsofCards.HEARTS),
      new Card(valueOfCards.FOUR, SuitsofCards.HEARTS),
      new Card(valueOfCards.FIVE, SuitsofCards.HEARTS),
      new Card(valueOfCards.SIX, SuitsofCards.HEARTS),
      new Card(valueOfCards.SEVEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.EIGHT, SuitsofCards.HEARTS),
      new Card(valueOfCards.NINE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TEN, SuitsofCards.HEARTS),
      //R8
      new Card(valueOfCards.JACK, SuitsofCards.HEARTS),
      new Card(valueOfCards.QUEEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.KING, SuitsofCards.HEARTS),
      new Card(valueOfCards.ACE, SuitsofCards.SPADES), //40th card
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.SPADES),
      new Card(valueOfCards.FOUR, SuitsofCards.SPADES),
      new Card(valueOfCards.FIVE, SuitsofCards.SPADES),
      new Card(valueOfCards.SIX, SuitsofCards.SPADES),
      //R9
      new Card(valueOfCards.SEVEN, SuitsofCards.SPADES),
      new Card(valueOfCards.EIGHT, SuitsofCards.SPADES),
      new Card(valueOfCards.NINE, SuitsofCards.SPADES),
      new Card(valueOfCards.TEN, SuitsofCards.SPADES),
      new Card(valueOfCards.JACK, SuitsofCards.SPADES),
      new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
      new Card(valueOfCards.KING, SuitsofCards.SPADES)
  ));

  public ArrayList<Card> listOfCardsTest1 = new ArrayList<Card>(Arrays.asList(
      //DIAMONDS
      //ROW 0
      new Card(valueOfCards.ACE, SuitsofCards.CLUBS),
      //ROW1
      new Card(valueOfCards.TWO, SuitsofCards.CLUBS),
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      //ROW2
      new Card(valueOfCards.FOUR, SuitsofCards.CLUBS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.SIX, SuitsofCards.CLUBS),
      //R3
      new Card(valueOfCards.SEVEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.EIGHT, SuitsofCards.CLUBS),
      new Card(valueOfCards.NINE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      //R4
      new Card(valueOfCards.JACK, SuitsofCards.CLUBS),
      new Card(valueOfCards.QUEEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.KING, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TWO, SuitsofCards.DIAMONDS),
      //R5
      new Card(valueOfCards.THREE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FOUR, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SEVEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.EIGHT, SuitsofCards.DIAMONDS),
      //R6
      new Card(valueOfCards.NINE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.JACK, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.QUEEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.KING, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.ACE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TWO, SuitsofCards.HEARTS),
      new Card(valueOfCards.THREE, SuitsofCards.HEARTS),
      //R7
      new Card(valueOfCards.FOUR, SuitsofCards.HEARTS),
      new Card(valueOfCards.FIVE, SuitsofCards.HEARTS),
      new Card(valueOfCards.SIX, SuitsofCards.HEARTS),
      new Card(valueOfCards.SEVEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.EIGHT, SuitsofCards.HEARTS),
      new Card(valueOfCards.NINE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.JACK, SuitsofCards.HEARTS),
      //R8
      new Card(valueOfCards.QUEEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.KING, SuitsofCards.HEARTS),
      new Card(valueOfCards.ACE, SuitsofCards.SPADES),
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.SPADES),
      new Card(valueOfCards.FOUR, SuitsofCards.SPADES),
      new Card(valueOfCards.FIVE, SuitsofCards.SPADES),
      new Card(valueOfCards.SIX, SuitsofCards.SPADES),
      new Card(valueOfCards.SEVEN, SuitsofCards.SPADES),
      //R9
      new Card(valueOfCards.EIGHT, SuitsofCards.SPADES),
      new Card(valueOfCards.NINE, SuitsofCards.SPADES),
      new Card(valueOfCards.TEN, SuitsofCards.SPADES),
      new Card(valueOfCards.JACK, SuitsofCards.SPADES),
      new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
      new Card(valueOfCards.KING, SuitsofCards.SPADES),
      //DIAMONDS
      //ROW 0
      new Card(valueOfCards.ACE, SuitsofCards.CLUBS),
      //ROW1
      new Card(valueOfCards.TWO, SuitsofCards.CLUBS),
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      //ROW2
      new Card(valueOfCards.FOUR, SuitsofCards.CLUBS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.SIX, SuitsofCards.CLUBS),
      //R3
      new Card(valueOfCards.SEVEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.EIGHT, SuitsofCards.CLUBS),
      new Card(valueOfCards.NINE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      //R4
      new Card(valueOfCards.JACK, SuitsofCards.CLUBS),
      new Card(valueOfCards.QUEEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.KING, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TWO, SuitsofCards.DIAMONDS),
      //R5
      new Card(valueOfCards.THREE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FOUR, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.SEVEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.EIGHT, SuitsofCards.DIAMONDS),
      //R6
      new Card(valueOfCards.NINE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.JACK, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.QUEEN, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.KING, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.ACE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TWO, SuitsofCards.HEARTS),
      new Card(valueOfCards.THREE, SuitsofCards.HEARTS),
      //R7
      new Card(valueOfCards.FOUR, SuitsofCards.HEARTS),
      new Card(valueOfCards.FIVE, SuitsofCards.HEARTS),
      new Card(valueOfCards.SIX, SuitsofCards.HEARTS),
      new Card(valueOfCards.SEVEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.EIGHT, SuitsofCards.HEARTS),
      new Card(valueOfCards.NINE, SuitsofCards.HEARTS),
      new Card(valueOfCards.TEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.JACK, SuitsofCards.HEARTS),
      //R8
      new Card(valueOfCards.QUEEN, SuitsofCards.HEARTS),
      new Card(valueOfCards.KING, SuitsofCards.HEARTS),
      new Card(valueOfCards.ACE, SuitsofCards.SPADES),
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.SPADES),
      new Card(valueOfCards.FOUR, SuitsofCards.SPADES),
      new Card(valueOfCards.FIVE, SuitsofCards.SPADES),
      new Card(valueOfCards.SIX, SuitsofCards.SPADES),
      new Card(valueOfCards.SEVEN, SuitsofCards.SPADES),
      //R9
      new Card(valueOfCards.EIGHT, SuitsofCards.SPADES),
      new Card(valueOfCards.NINE, SuitsofCards.SPADES),
      new Card(valueOfCards.TEN, SuitsofCards.SPADES),
      new Card(valueOfCards.JACK, SuitsofCards.SPADES),
      new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
      new Card(valueOfCards.KING, SuitsofCards.SPADES)
  ));
  public ArrayList<Card> listEmpty = new ArrayList<Card>();
  public ArrayList<Card> deckWrongSize = new ArrayList<Card>(Arrays.asList(
      //DIAMONDS
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      new Card(valueOfCards.FOUR, SuitsofCards.HEARTS),
      new Card(valueOfCards.KING, SuitsofCards.CLUBS)
  ));

  public ArrayList<Card> deckDuplicates = new ArrayList<Card>(Arrays.asList(
      //DIAMONDS
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.TWO, SuitsofCards.SPADES),
      new Card(valueOfCards.THREE, SuitsofCards.CLUBS),
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS)
  ));

  @Test
  public void testgetDeck() {
    assertEquals(listOfCardsTest1, model.getDeck());
  }

  //test StartGane: test State Exception for StartGame
  @Test(expected = IllegalArgumentException.class)
  public void teststartGameEXCEPTIONS() {
    // should return an exception because the list is null
    model.startGame(null, false, 8, 9);
    //should return an exception because list is empty
    model.startGame(listEmpty, false, 8, 0);
    //should return an exception because the list is the wrong size
    model.startGame(deckWrongSize, false, 1, 0);
    //should return an exception because their are duplicates in the list
    model.startGame(deckDuplicates, false, 3, 0);
    //should return an exception because the number of rows is not in the bound
    model.startGame(listOfCardsTest, false, -1, 16);
    //should return an exception because the number of rows is out of bounds
    model.startGame(listOfCardsTest, false, 9, 16);
    //should return an exception because the number draw is wrong
    model.startGame(listOfCardsTest, false, 8, 6);
    //Should return an exception because number of rows is greater than 9
    model.startGame(listOfCardsTest, false, 10, -1);
  }


}
