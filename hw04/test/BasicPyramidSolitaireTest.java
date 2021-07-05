import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;

import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * rerepsents the testing class for basic pyramid solitaire.
 */
public class BasicPyramidSolitaireTest {

  BasicPyramidSolitaire model;

  @Before
  public void setUp() {
    model = new BasicPyramidSolitaire();
  }

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
      new Card(valueOfCards.KING, SuitsofCards.SPADES)
  ));
  public ArrayList<Card> stockOflistOfCardsTest = new ArrayList<Card>(
      Arrays.asList(new Card(valueOfCards.SEVEN, SuitsofCards.SPADES),
          new Card(valueOfCards.EIGHT, SuitsofCards.SPADES),
          new Card(valueOfCards.NINE, SuitsofCards.SPADES),
          new Card(valueOfCards.TEN, SuitsofCards.SPADES),
          new Card(valueOfCards.JACK, SuitsofCards.SPADES),
          new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
          new Card(valueOfCards.KING, SuitsofCards.SPADES))
  );
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
      new Card(valueOfCards.KING, SuitsofCards.SPADES)
  ));

  public ArrayList<Card> listOfCardsTest2 = new ArrayList<Card>(Arrays.asList(
      //DIAMONDS
      //ROW 0
      new Card(valueOfCards.KING, SuitsofCards.CLUBS),
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
      new Card(valueOfCards.ACE, SuitsofCards.CLUBS),
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

  public ArrayList<Card> drawCardsforsmallDeckforStock = new ArrayList<Card>(Arrays.asList(
      new Card(valueOfCards.FOUR, SuitsofCards.CLUBS),
      new Card(valueOfCards.FIVE, SuitsofCards.CLUBS),
      new Card(valueOfCards.SIX, SuitsofCards.CLUBS),
      new Card(valueOfCards.SEVEN, SuitsofCards.CLUBS),
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS)
  ));

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
      new Card(valueOfCards.TEN, SuitsofCards.CLUBS)

  ));
  public ArrayList<Card> listEmpty = new ArrayList<Card>();

  //test GetDeck: it returns a full deck
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
    model.startGame(listOfCardsTest,false,10,-1);
  }


  //test for startGame: test when the game is not shuffled
  // checking if the position of the card is correct in the pyramid
  // also tests getCard to ensure it gets the card in the correct position
  @Test
  public void testStartGameShuffleFalse() {
    //checks if the game has started with list not shuffled: by checking if there is the correct
    //card in the deck
    model.startGame(listOfCardsTest, false, 8, 16);
    assertEquals(new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
        model.getCardAt(2, 2));
    assertEquals(new Card(valueOfCards.ACE, SuitsofCards.CLUBS), model.getCardAt(4, 3));
  }

  //test for startGame: test when the game is shuffled
  //shuffles the cards then checks if the card at that location is no longer the same
  // not the best way of testing shuffle because the card could have NOT changed positions
  @Test
  public void testStartGameShuffleTrue() {
    //checks if the game has started and that the list is shuffled: by checking
    //method doesn't seem to shuffle; here I used the same model as the test above
    //but the cards do not change position
    model.startGame(listOfCardsTest, true, 8, 16);
    assertNotEquals(new Card(valueOfCards.SIX, SuitsofCards.DIAMONDS),
        model.getCardAt(2, 2));
    assertNotEquals(new Card(valueOfCards.ACE, SuitsofCards.HEARTS),
        model.getCardAt(4, 3));
  }

  //test for Remove with two cards :Illegal State Exceptions for remove with two cards
  @Test(expected = IllegalStateException.class)
  public void testRemoveExceptions() {
    model.remove(1, 1, 2, 1);
  }

  //test for Remove with two cards: Illegal Argument Exceptions for remove with two cards
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveExceptions1() {
    model.startGame(listOfCardsTest, false, 8, 16);
    //error sum not equal to 13 and error for cards not being exposed
    model.remove(1, 1, 2, 1);
    //card and row values invalid
    model.remove(-1, -1, -1, -2);
    //car
  }

  //test for Remove with two cards
  //remove two cards from the pyramid and checks if they are equal to null
  //remove method sets the removed cards to null
  @Test
  public void testRemove() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.remove(8, 4, 8, 0);
    assertEquals(null, model.getCardAt(8, 4)); //Jack.Hearts
    assertEquals(null, model.getCardAt(8, 0)); //Two.Spades
  }

  //test for removing one card: Illegal Argument Exception
  @Test(expected = IllegalArgumentException.class)
  public void testRemovedCardsArgumentEception() {
    model.startGame(listOfCardsTest, false, 9, 7);
    //card and row indexes are wrong
    model.remove(10, 0, 10, 9);
    //card is not exposed
    model.remove(10, 7, 0, 9);
    //game has not been started
    model.startGame(listOfCardsTest, false, -1, 7);
  }

  //testing for removing one cards: removes one card from the pyramid
  @Test
  public void testRemovev1() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.remove(8, 2); // King.Hearts
    assertEquals(null, model.getCardAt(8, 2));
  }

  //Testing for remove with one card: Illegal Argument Exception
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveArgumentException() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.remove(8,4);
  }

  //test for removing one card: Illegal Argument Exception
  @Test(expected = IllegalArgumentException.class)
  public void testRemovedCardsStateException() {
    model.startGame(listOfCardsTest, false, -1, 7);
  }

  //test for removing using draw
  @Test
  public void testRemovingUsingDraw() {
    model.startGame(listOfCardsTest, false, 9, 7);
    //remove the cards from the stock and pyramid
    model.removeUsingDraw(4, 8, 4); //jack.spades in draw, in pyramid two.spades
    //check if the card removed is equal to null
    assertEquals(null, model.getCardAt(8, 4));
    //check if the card removed from pyramid is equal to null
    assertEquals(new Card(valueOfCards.QUEEN, SuitsofCards.SPADES),
        model.getDrawCards().get(4)); //two.spades
  }

  //test for removing using draw: illegal argument exception
  @Test(expected = IllegalArgumentException.class)
  public void testRemovingUsingDrawExceptions() {
    model.startGame(listOfCardsTest, false, 9, 7);
    //index are invalid
    model.removeUsingDraw(-1, 10, -1);
  }

  //test for removing using draw: illegal state exception
  @Test(expected = IllegalStateException.class)
  public void testRemovingUsingDrawStateException() {
    //game has not started
    model.removeUsingDraw(-1, 10, -1);
  }

  //test for discarding a card from draw pile
  @Test
  public void discardDraw() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.discardDraw(2); // nine.spades
    //check to see if the card has been replaced with the next card
    //by checking if their number value match in the deck
    //So initialy in that spot was a nine.spades and now it should be a ten.spades
    assertEquals(10, listOfCardsTest.get(48).getNumberOfCard());
    assertEquals(SuitsofCards.SPADES, listOfCardsTest.get(48).getRankofCard());
  }

  //test: DiscardDrawException, argument exception
  @Test(expected = IllegalArgumentException.class)
  public void discardDrawExceptions() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.discardDraw(-1);
    model.discardDraw(9);
  }

  //test: DiscardDrawException, state exception
  @Test(expected = IllegalStateException.class)
  public void discardDrawStateExceptions() {
    //model.startGame(listOfCardsTest, false, 9, 7);
    model.discardDraw(-1);
    model.discardDraw(9);
  }

  //test: gets the number row
  @Test
  public void getnumRows() {
    model.startGame(listOfCardsTest, false, 9, 7);
    assertEquals(9, model.getNumRows());
  }

  //test:gets the number draw
  @Test
  public void getnumDraw() {
    model.startGame(listOfCardsTest, false, 9, 7);
    assertEquals(7, model.getNumDraw());
  }


  //tests: gets the width of a specifc row
  @Test
  public void getRowWidth() {
    model.startGame(listOfCardsTest, false, 9, 7);
    assertEquals(3, model.getRowWidth(2));
  }

  //test: DiscardDrawException
  @Test(expected = IllegalStateException.class)
  public void getRowWidthStateException() {
    // model.startGame(listOfCardsTest, false, 9, 7);
    model.getRowWidth(-1);
    model.getRowWidth(10);
  }

  //test: DiscardDrawException
  @Test(expected = IllegalArgumentException.class)
  public void getRowWidthArgumentException() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.getRowWidth(-1);
    model.discardDraw(10);
  }


  //test if the game is over by checking if the deck of card has moves
  //in this case the deck doesn't have moves
  @Test
  public void isGameOver() {
    model.startGame(listOfCardsTest, false, 9, 7);
    model.getScore();
    assertEquals(false, model.isGameOver());
    //checks if the game is actually over by, placing one card
    model.startGame(listOfCardsTest2, false, 1, 1);
    model.remove(0, 0);
    assertEquals(true, model.isGameOver());
  }

  //isGameOver: test if the game has not been started
  @Test(expected = IllegalStateException.class)
  public void isGameOverStateException() {
    model.isGameOver();
  }

  //getscore: checks the score for the specific model
  //in this case for the smallDeckforStock the total number is equal to
  //81
  @Test
  public void getScore() {
    model.startGame(listOfCardsTest, false, 3, 46);
    assertEquals(21, model.getScore());
  }

  //getsCORE: test if the game has not been started
  @Test(expected = IllegalStateException.class)
  public void getScoreStateException() {
    model.getScore();
  }

  //test getCardAt
  @Test
  public void getCardAt() {
    model.startGame(listOfCardsTest, false, 3, 46);
    assertEquals(new Card(valueOfCards.TWO, SuitsofCards.DIAMONDS), model.getCardAt(1, 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCardAtException() {
    model.startGame(listOfCardsTest, false, 3, 46);
    model.getCardAt(5, 10);
  }

  @Test(expected = IllegalStateException.class)
  public void getCardAtStateException() {
    // model.startGame(listOfCardsTest, false, -1, 46);
    model.getCardAt(5, 10);
  }


  @Test
  public void getDrawCards() {
    model.startGame(listOfCardsTest, false, 9, 7);
    assertEquals(stockOflistOfCardsTest, model.getDrawCards());
  }

}