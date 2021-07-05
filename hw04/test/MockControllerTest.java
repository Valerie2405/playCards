import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.controller.MockController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.StringReader;
import org.junit.Test;

/**
 * A mock of controller.
 */
public class MockControllerTest {

  @Test
  public void babytest() {
    //the readeable input to the mock
    StringReader reader = new StringReader("dd 1");
    //appendable
    //StringBuilder output that you pass to mock controller constructor
    StringBuilder builder = new StringBuilder();
    //make a new controller
    PyramidSolitaireController mockController = new MockController(reader, builder);

    PyramidSolitaireModel model = new BasicPyramidSolitaire();

    mockController.playGame(model, model.getDeck(), true, 4, 3);

    //checks to see if the inputs are correct
    assertEquals("dd 1 ", builder.toString());

  }

}
