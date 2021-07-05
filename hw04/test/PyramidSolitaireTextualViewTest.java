import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Represents the textual view of the game.
 */
public class PyramidSolitaireTextualViewTest {

  BasicPyramidSolitaire model;
  PyramidSolitaireTextualView view;


  @Before
  public void setUp() {
    model = new BasicPyramidSolitaire();
    view = new PyramidSolitaireTextualView(model);
  }


  //DECK OF CARDS
  //DECK OF CARDS
  public ArrayList<Card> listOfCardsTest = new ArrayList<>(Arrays.asList(
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
      new Card(valueOfCards.KING, SuitsofCards.DIAMONDS),
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
      new Card(valueOfCards.ACE, SuitsofCards.DIAMONDS),
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
  public ArrayList<Card> listOfCardsTest3 = new ArrayList<>(Arrays.asList(
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

  //checks if the game has not started yet
  //in constructor numDraw is already to set-1 to
  //signify that the game has not been started
  @Test
  public void toStringTest1() {
    String str = view.toString();
    assertEquals("", str);
  }

  //checks if the game has been won
  //with a list with one card
  //call remove to remove then card since it is 13
  //then game has been won
  @Test
  public void toStrinTestifGameisWon() {
    model.startGame(listOfCardsTest2, false, 1, 51);
    model.remove(0, 0);
    String str = view.toString();
    assertEquals("You win!", str);
  }

  //checks to see if the game returns the score correctly -- ERROR WON'T RETURN SCORE
  @Test
  public void toStrinTesting() {
    model.startGame(listOfCardsTest2, false, 2, 1);
    model.getScore();
    String str = view.toString();
    assertEquals("Game over. Score: " + 21, str);
  }

  //prints out a functional pyramid with no nulls
  @Test
  public void toStringTestPyramid() {
    model.startGame(listOfCardsTest, false, 3, 1);
    String str = view.toString();
    assertEquals("    A♦\n"
        + "  2♦  3♦\n"
        + "4♦  5♦  6♦\n"
        + "Draw:7♦", str);
  }

  //Test Pyramid has null values will render to a period
  @Test
  public void toStringTestPyramidwithNull() {
    model.startGame(listOfCardsTest, false, 3, 1);
    model.removeUsingDraw(0, 2, 2);
    String str = view.toString();
    System.out.println(listOfCardsTest.size());
    assertEquals("    A♦\n"
        + "  2♦  3♦\n"
        + "4♦  5♦  .\n"
        + "Draw:8♦", str);

  }


}
