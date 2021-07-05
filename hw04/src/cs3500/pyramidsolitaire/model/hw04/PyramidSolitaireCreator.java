package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Creates a pyramidSolitaire Game.
 */
public class PyramidSolitaireCreator {

  /**
   * an Enum to represent the game type.
   */
  public enum GameType {
    BASIC,
    MULTIPYRAMID,
    RELAXED
  }

  /**
   * returns a class of type PyramidSolitaire.
   *
   * @param basic represents the game type
   * @return returns a game
   */
  public static PyramidSolitaireModel<Card> create(GameType basic) {
    if (basic.equals(GameType.BASIC)) {
      return new BasicPyramidSolitaire();
    } else if (basic.equals(GameType.MULTIPYRAMID)) {
      return new MultiPyramidSolitaire();
    } else if (basic.equals(GameType.RELAXED)) {
      return new RelaxedPyramidSolitaire();
    }
    return null;
  }

}
