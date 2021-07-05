import static org.junit.Assert.assertTrue;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import org.junit.Test;

/**
 * CLass to test the factory class.
 */
public class PyramidSolitaireCreatorTest {

  @Test
  public void createTestBasic() {
    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> modelBasic = PyramidSolitaireCreator.create(GameType.BASIC);
    assertTrue(modelBasic instanceof BasicPyramidSolitaire);
  }

  @Test
  public void createTestRelaxed() {
    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> modelBasic = PyramidSolitaireCreator.create(GameType.RELAXED);
    assertTrue(modelBasic instanceof RelaxedPyramidSolitaire);
  }

  @Test
  public void createTestMULTI() {
    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> modelBasic = PyramidSolitaireCreator.create(GameType.MULTIPYRAMID);
    assertTrue(modelBasic instanceof MultiPyramidSolitaire);
  }

  //checks if the input is null
  @Test(expected = IllegalStateException.class)
  public void createTestNull() {
    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> modelBasic = PyramidSolitaireCreator.create(null);
  }
}
