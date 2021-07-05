package cs3500.pyramidsolitaire;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import java.io.InputStreamReader;

/**
 * Represents the game class to actually play the game.
 */
public final class PyramidSolitaire extends PyramidSolitaireCreator {

  /**
   * Class to represent the main in order to play the game.
   *
   * @param args represents the arguments
   */
  public static void main(String[] args) {
    PyramidSolitaireModel<Card> model;

    switch (args[0]) {
      case "basic":
        model = PyramidSolitaire.create(GameType.BASIC);
        break;
      case "relaxed":
        model = PyramidSolitaire.create(GameType.RELAXED);
        break;
      case "multipyramid":
        model = PyramidSolitaire.create(GameType.MULTIPYRAMID);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + args[0]);
    }

    PyramidSolitaireController controller = new PyramidSolitaireTextualController(
        new InputStreamReader(System.in), System.out);

    assert model != null;
    controller.playGame(model, model.getDeck(), true, Integer.parseInt(args[1]),
        Integer.parseInt(args[2]));
  }

}