import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.junit.Test;

/**
 * Represents the testing for the controller.
 */
public class PyramidSolitaireTextualControllerTest {

  /**
   * represents the main function to actually run the program.
   *
   * @param args argument take in
   */
  public static void main(String[] args) {
    BasicPyramidSolitaire model = new BasicPyramidSolitaire();
    PyramidSolitaireController controller =
        new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out);
    controller.playGame(model, model.getDeck(), true, 3, 7);
  }

  //BASIC PYRAMID SOLITAIRE

  //test for playGame():discard Draw
  @Test
  public void testPlayGameDiscardDraw() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for playGame():discard Draw negative number
  @Test
  public void testPlayGameDiscardDrawNegative() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd -1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "The index is invalid\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", out.toString());
  }


  //test for playGame(): dd q 1
  @Test
  public void testDiscardDrawquitnumber() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd q 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21", out.toString());
  }


  @Test
  public void testPlayGameDiscardDrawLetter() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd e 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }


  @Test
  public void testPlayGameDiscardDrawNumber() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "unrecognized input:1\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", out.toString());
  }

  //test for rm1():throws an illegal argument because that card is not a king
  @Test()
  public void testrm1IlegalMove() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 3 3");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "Cannot remove a non-king value by itself\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", out.toString());
  }


  //test for rm1(): inputs a valid input
  @Test
  public void testrm1Validinput() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 3");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  .   A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //test for rm1(): inputs a valid input
  @Test
  public void testrm1ValidinputLetter() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 e 3 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "the card is not exposed\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with quit
  @Test
  public void testrm1withQ() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 q 3");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94", out.toString());
  }

  //rm1 test: with quit
  @Test()
  public void testrm1withNegativeNum() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 -1 2");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "attempt is invalid because the row number is below 0 OR the row you've entered "
        + "is greater then the number of rows in the pyramid\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm2 test: with valid inputs
  @Test
  public void testrm2ValidInputs() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 1 5 5");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + ".  Q♣  K♣  A♦  . \n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm2 test: with illegalMove
  @Test
  public void testrm2illegalMove() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 4 1 2 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with negative index
  @Test
  public void testrm2negativeInput() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 -4 -1 -1 -1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "The row number exceeds the number of rows or the number of rows is smaller than 0 \n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with q letter
  @Test()
  public void testrm2withQ() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 q 5 5");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94", out.toString());
  }

  //rm2 test: with q letter
  @Test
  public void testrm2ValidinputLetter() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 e 3 1 5 1 ");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }


  //test for rmwd():
  @Test
  public void testrmwdValidInputs() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 6 4 4");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣  . \n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 4♦,5♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdValidinputLetter() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd e 4 4 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The cards do not sum to 13\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdQuit() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd q 4 4");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdInvalidMove() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 4 4");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The cards do not sum to 13\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdwithNegativeNum() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd -1 -4 -4");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The index is invalid\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameQuit() {
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("q"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21", gametesLog.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameInvalidInput() {
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("e"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "unrecognized input:e\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", gametesLog.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameInvalidInputNumber() {
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("1"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "unrecognized input:1\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", gametesLog.toString());
  }

  //test for when the game is quit
  @Test
  public void testQuitGame() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 0);
    assertEquals("Game over. Score: 21", out.toString());
  }

  @Test
  public void testWin() {
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 1, 1);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameInvalidParam() {
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 0, 10);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void readableNull() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(null, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 0);
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void appendableNull() {
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new BasicPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, null);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 0);
  }

  //--------------------------------------------RELAXED PYRAMID TEST-------------------------------

  @Test
  public void RelaxedRemoveRelaxed() {
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    listCard.add(0, listCard.remove(10));//jackcard
    listCard.add(2, listCard.remove(1)); //two card
    listCard.add(1, listCard.remove(12)); //king card
    listCard.set(1, null);

    StringBuilder out = new StringBuilder();
    Reader in1 = new StringReader("rm2 1 1 2 2"); // removes the Jack and Two
    PyramidSolitaireController controllerTest1 = new PyramidSolitaireTextualController(in1, out);
    controllerTest1.playGame(modelTest, listCard, false, 2, 1);

    assertEquals("  J♣\n"
        + ".  2♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  //test for playGame():discard Draw
  @Test
  public void testPlayGameDiscardDrawRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for playGame():discard Draw negative number
  @Test
  public void testPlayGameDiscardDrawNegativeRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd -1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "The index is invalid\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", out.toString());
  }

  //test for playGame(): dd q 1
  @Test
  public void testDiscardDrawquitnumberRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd q 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21", out.toString());
  }

  @Test
  public void testPlayGameDiscardDrawLetterRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd e 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  @Test()
  public void testrm1IlegalMoveRelaxed() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 3 3");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦\n"
        + "Score: 21\n"
        + "Cannot remove a non-king value by itself\n"
        + "    A♣\n"
        + "  2♣  3♣\n"
        + "4♣  5♣  6♣\n"
        + "Draw: 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♦, 2♦,3♦", out.toString());
  }

  //test for rm1(): inputs a valid input
  @Test
  public void testrm1ValidinputRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 3");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  .   A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //test for rm1(): inputs a valid input
  @Test
  public void testrm1ValidinputLetterRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 e 3 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "the card is not exposed\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with quit
  @Test
  public void testrm1withQRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 q 3");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94", out.toString());
  }

  //rm1 test: with quit
  @Test()
  public void testrm1withNegativeNumRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 -1 2");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "attempt is invalid because the row number is below 0 OR the row you've entered"
        + " is greater then the number of rows in the pyramid\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm2 test: with valid inputs
  @Test
  public void testrm2ValidInputsRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 1 5 5");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + ".  Q♣  K♣  A♦  . \n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm2 test: with illegalMove
  @Test
  public void testrm2illegalMoveRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 4 1 2 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with negative index
  @Test
  public void testrm2negativeInputRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 -4 -1 -1 -1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "The row number exceeds the number of rows or the number of rows is smaller than 0 \n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //rm1 test: with q letter
  @Test()
  public void testrm2withQRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 q 5 5");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94", out.toString());
  }

  //rm2 test: with q letter
  @Test
  public void testrm2ValidinputLetterRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 e 3 1 5 1 ");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 94\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣\n"
        + "      2♣  3♣\n"
        + "    4♣  5♣  6♣\n"
        + "  7♣  8♣  9♣ 10♣\n"
        + "J♣  Q♣  K♣  A♦  2♦\n"
        + "Draw: 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }


  //test for rmwd():
  @Test
  public void testrmwdValidInputsRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 6 4 4");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣  . \n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 4♦,5♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdValidinputLetterRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd e 4 4 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The cards do not sum to 13\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdQuitRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd q 4 4");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdInvalidMoveRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 4 4");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The cards do not sum to 13\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdwithNegativeNumRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd -1 -4 -4");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦\n"
        + "Score: 55\n"
        + "The index is invalid\n"
        + "      A♣\n"
        + "    2♣  3♣\n"
        + "  4♣  5♣  6♣\n"
        + "7♣  8♣  9♣ 10♣\n"
        + "Draw: J♣, Q♣, K♣, A♦, 2♦, 3♦,4♦", out.toString());
  }

  //test for when the game is quit
  @Test
  public void testQuitGameRELAXED() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 0);
    assertEquals("Game over. Score: 21", out.toString());
  }

  @Test
  public void testWinRELAXED() {
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 1, 1);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameInvalidParamRELAXED() {
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 0, 10);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void readableNullRELAXED() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(null, out);
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void appendableNullRELAXED() {
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new RelaxedPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, null);
  }

  //---------------------------------------------MULTI PYRAMID TEST------------------------------
  //test for playGame():discard Draw
  @Test
  public void testPlayGameDiscardDrawMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦,10♦", out.toString());
  }

  //test for playGame():discard Draw negative number
  @Test
  public void testPlayGameDiscardDrawNegativeMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd -1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "The index is invalid\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }

  //test for playGame(): dd q 1
  @Test
  public void testDiscardDrawquitnumberMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd q 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78", out.toString());
  }

  @Test
  public void testPlayGameDiscardDrawLetterMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd e 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦,10♦", out.toString());
  }


  @Test
  public void testPlayGameDiscardDrawNumberMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
            + "  4♣  5♣  6♣  7♣\n"
            + "8♣  9♣ 10♣  J♣  Q♣\n"
            + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
            + "Score: 78\n"
            + "unrecognized input:1\n"
            + "    A♣  2♣  3♣\n"
            + "  4♣  5♣  6♣  7♣\n"
            + "8♣  9♣ 10♣  J♣  Q♣\n"
            + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦",
        out.toString());
  }

  //test for rm1():throws an illegal argument because that card is not a king
  @Test()
  public void testrm1IlegalMoveMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 3 3");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "Cannot remove a non-king value by itself\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", out.toString());
  }


  //test for rm1(): inputs a valid input
  @Test
  public void testrm1ValidinputMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 2");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
            + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
            + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
            + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
            + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
            + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
            + "Score: 210\n"
            + "        A♣  .   2♣  .   3♣\n"
            + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
            + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
            + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
            + "Q♦  .   A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
            + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠",
        out.toString());
  }

  //test for rm1(): inputs a valid input
  @Test
  public void testrm1ValidinputLetterMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 e 5 2");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  .   A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠", out.toString());
  }

  //rm1 test: with quit
  @Test
  public void testrm1withQMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 q 3");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210", out.toString());
  }

  //rm1 test: with quit
  @Test()
  public void testrm1withNegativeNumMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 -1 2");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "attempt is invalid because the row number is below 0 "
        + "OR the row you've entered is greater then the number of rows in the pyramid\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠", out.toString());
  }

  //rm2 test: with valid inputs
  @Test
  public void testrm2ValidInputsMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    listCard.add(2, listCard.remove(10));// jack
    listCard.add(5, listCard.remove(12)); // KING
    listCard.add(5, listCard.remove(1)); // two

    listCard.set(4, null);

    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 1 1 2 3");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 2, 7);
    assertEquals("  A♣  J♣  3♣\n"
        + "4♣  .   2♣  5♣\n"
        + "Draw: 6♣, 7♣, 8♣, 9♣, 10♣, Q♣,A♦\n"
        + "Score: 26\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "  A♣  J♣  3♣\n"
        + "4♣  .   2♣  5♣\n"
        + "Draw: 6♣, 7♣, 8♣, 9♣, 10♣, Q♣,A♦\n", out.toString());
  }

  //rm2 test: with illegalMove
  @Test
  public void testrm2illegalMoveMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 4 1 2 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠", out.toString());
  }

  //rm1 test: with negative index
  @Test
  public void testrm2negativeInputMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 -4 -1 -1 -1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "The row number exceeds the number of rows or the number of rows is smaller than 0 \n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠", out.toString());
  }

  //rm1 test: with q letter
  @Test()
  public void testrm2withQMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 q 5 5");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210", out.toString());
  }

  //rm2 test: with q letter : need to fix and find an actual move that works
  //works when game is played
  @Test
  public void testrm2ValidinputLetterMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 e 3 1 5 1 ");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "This removal is invalid because the cards are not equal to 13\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠", out.toString());
  }


  //test for rmwd():
  @Test
  public void testrmwdValidInputsMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 4 5 4");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  .   3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, Q♥, K♥, A♠,2♠", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdValidinputLetterMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd e 4 5 4");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 5, 7);
    assertEquals("        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  2♥  3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, J♥, Q♥, K♥,A♠\n"
        + "Score: 210\n"
        + "        A♣  .   2♣  .   3♣\n"
        + "      4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "    10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Q♦  K♦  A♥  .   3♥  4♥  5♥  6♥  7♥\n"
        + "Draw: 8♥, 9♥, 10♥, Q♥, K♥, A♠,2♠", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdQuitMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd q 4 4");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥\n"
        + "Score: 157\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥\n"
        + "Score: 157", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdInvalidMoveMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 4 4");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥\n"
        + "Score: 157\n"
        + "The cards do not sum to 13\n"
        + "      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥", out.toString());
  }

  //test for rmwd():
  @Test
  public void testrmwdwithNegativeNumMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd -1 -4 -4");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 4, 7);
    assertEquals("      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥\n"
        + "Score: 157\n"
        + "The index is invalid\n"
        + "      A♣  .   2♣  .   3♣\n"
        + "    4♣  5♣  6♣  7♣  8♣  9♣\n"
        + "  10♣  J♣  Q♣  K♣  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦\n"
        + "Draw: Q♦, K♦, A♥, 2♥, 3♥, 4♥,5♥", out.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameQuitMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("q"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "Game quit!\n"
        + "State of game when quit\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78", gametesLog.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameInvalidInputMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("e"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "unrecognized input:e\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", gametesLog.toString());
  }

  //test for playGame(): test for when the user quits out of the game
  @Test
  public void testPlayGameInvalidInputNumberMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    StringBuilder gametesLog = new StringBuilder();
    PyramidSolitaireController controllerTest =
        new PyramidSolitaireTextualController(new StringReader("1"), gametesLog);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 10);
    assertEquals("    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦\n"
        + "Score: 78\n"
        + "unrecognized input:1\n"
        + "    A♣  2♣  3♣\n"
        + "  4♣  5♣  6♣  7♣\n"
        + "8♣  9♣ 10♣  J♣  Q♣\n"
        + "Draw: K♣, A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦,9♦", gametesLog.toString());
  }

  //test for when the game is quit
  @Test
  public void testQuitGameMULTI() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, modelTest.getDeck(), false, 3, 0);
    assertEquals("Game over. Score: 78", out.toString());
  }

  @Test
  public void testWinMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 1, 1);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameInvalidParamMULTI() {
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();

    List<Card> listCard = modelTest.getDeck();
    Card kingCard = listCard.get(12);
    listCard.remove(12);
    listCard.add(0, kingCard);
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 1");
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, out);
    controllerTest.playGame(modelTest, listCard, false, 0, 10);
    assertEquals("K♣\n"
        + "Draw:A♣\n"
        + "Score: 13\n"
        + "You win!", out.toString());
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void readableNullMULTI() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(null, out);
  }

  //test for when the game is quit
  @Test(expected = IllegalArgumentException.class)
  public void appendableNullMULTI() {
    Reader in = new StringReader("dd 1");
    PyramidSolitaireModel<Card> modelTest = new MultiPyramidSolitaire();
    PyramidSolitaireController controllerTest = new PyramidSolitaireTextualController(in, null);
  }

}