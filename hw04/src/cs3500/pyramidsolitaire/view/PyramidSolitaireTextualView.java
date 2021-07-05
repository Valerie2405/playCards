package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;

/**
 * Represents the textual view of the pyramid.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  private Appendable ap;

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {

    this.model = model;
  }

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  /**
   * Renders a model in some manner (e.g. as text, or as graphics, etc.).
   *
   * @throws IOException if the rendering fails for some reason.
   */
  @Override
  public void render() throws IOException {
    ap.append(this.toString());
  }


  //creates the spaces infront of the cards
  private String getFrontTab(int rowIndex) {
    int numTwoSpaces = model.getNumRows() - (rowIndex + 1);
    StringBuilder frontTab = new StringBuilder();
    for (int i = 0; i < numTwoSpaces; i++) {
      frontTab.append("  ");
    }
    return frontTab.toString();
  }

  @Override
  public String toString() {
    if (model.getNumDraw() == -1) { //game hasnt started yet
      return "";
    } else if (model.getScore() == 0) { //game won
      return "You win!";
    } //checks if game over and returns score
    else if (model.isGameOver()) {
      return "Game over. Score: " + model.getScore();
    } else { //game is ongoing
      //print pyramid
      StringBuilder gameString = new StringBuilder();
      for (int i = 0; i < model.getNumRows(); i++) { //iterates over every row
        StringBuilder rowString = new StringBuilder();
        for (int j = 0; j < model.getRowWidth(i); j++) {
          if (j == 0) {
            rowString.append(this.getFrontTab(i))
                .append(model.getCardAt(i, j) == null ? "." : model.getCardAt(i, j).toString());
            //append(model.getCardAt(i, j).toString());
          } else {
            if (model.getCardAt(i, j) != null && model.getCardAt(i, j).toString().contains("10")) {
              rowString.append(" ")
                  .append(model.getCardAt(i, j) == null ? "." : model.getCardAt(i, j).toString());
            } else {
              rowString.append("  ")
                  .append(model.getCardAt(i, j) == null ? ". " : model.getCardAt(i, j).toString());
            }
          }
        }
        gameString.append(rowString).append("\n");
      }

      //print draw card line
      StringBuilder drawString = new StringBuilder("Draw:");
      // drawString += " " + model.getDrawCards().get(i).toString();
      for (int i = 0; i < model.getDrawCards().size() - 1; i++) {
        drawString.append(" ")
            .append(
                model.getDrawCards().get(i) == null ? "." : model.getDrawCards().get(i).toString())
            .append(",");
      }
      if (model.getDrawCards().size() != 0) {
        drawString.append(model.getDrawCards().get(model.getDrawCards().size() - 1).toString());
      }

      gameString.append(drawString);

      return gameString.toString();
    }
  }

}