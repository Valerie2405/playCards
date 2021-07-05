package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a mockController.
 */
public class MockController implements PyramidSolitaireController {


  private Readable rd;
  private Appendable ap;
  private Scanner scan;

  public MockController(Readable rd, Appendable ap) {
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * The primary method for beginning and playing a game.
   *
   * @param model   The game of solitaire to be played
   * @param deck    The deck of cards to be used
   * @param shuffle Whether to shuffle the deck or not
   * @param numRows How many rows should be in the pyramid
   * @param numDraw How many draw cards should be visible
   * @throws IllegalArgumentException if the model or deck is null
   * @throws IllegalStateException    if the game cannot be started, or if the controller cannot
   *                                  interact with the player.
   */
  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
      int numRows, int numDraw) {
    Scanner scan = new Scanner(rd);
    while (scan.hasNext()) {
      try {
        ap.append(scan.next()).append(" ");
      } catch (IOException e) {
        //
      }
    }
    /*
    in your test
    String builder, give it an input, call string builder
    stringbuilder.to string() and read the log
     one class to test the interface
     - test each method inside it
     */
  }
}
