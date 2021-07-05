package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a relaxedPyramid Solitaire game.
 */
public class RelaxedPyramidSolitaire extends AbstractPyramidSolitaire implements
    PyramidSolitaireModel<Card> {

  public RelaxedPyramidSolitaire() {
    super();
  }

  //Remove method

  /**
   * Method determines if a specific card is exposed depending on the two cards below it.
   *
   * @return a boolean true if exposed false if not exposed
   */
  @Override
  protected boolean isCardExposed(int row, int card) {
    //if this is the last row than it is exposed
    if (row == this.numRows - 1) {
      return true;
    }
    //if the card below are removed than it is exposed
    else if (getCardAt(row, card).getNumberOfCard() == 13) {
      //if one of the cards below is removed
      return (this.getCardAt(row + 1, card) == null) &&
          //if the other cards below is removed
          (this.getCardAt(row + 1, card + 1) == null);
    } else {
      //if one of the cards below is removed
      return (this.getCardAt(row + 1, card) == null) ||
          //if the other cards below is removed
          (this.getCardAt(row + 1, card + 1) == null);
    }
  }

  /**
   * checks if game is over.
   *
   * @return returns a boolean indicating if the game is over
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public boolean isGameOver() throws IllegalStateException {
    List<Card> pileOfExposedCards = new ArrayList<>();
    if (this.numRows == -1) {
      throw new IllegalStateException("The game has not begun yet !");
      //if the score is equal to 0 then the game is over
    } else if (getScore() == 0) {
      return true;
    } else if (getDrawCards().size() > 0 && stock.size() != 0) {
      return false;
    } else {
      //for each card in the pyramid
      for (List<Card> rowCard : this.pyramidList) {
        //variable to get the row index of the card
        int cardRowIndex = pyramidList.indexOf(rowCard);
        for (Card card : rowCard) {
          if (card != null) {
            //variable to get the card number (column) of the card
            int cardColumnIndex = rowCard.indexOf(card);
            //check to see if that specific card is exposed
            if (isCardExposed(cardRowIndex, cardColumnIndex)) {
              //iterate again through the entire pyramid
              pileOfExposedCards.add(card);
              // pileOfExposedCards.add();
            }
          }
        }
      }
      //checks to see if the card in the exposed pile are equal to 13, or add to 13
      for (int i = 0; i < pileOfExposedCards.size(); i++) {
        for (int j = i + 1; j < pileOfExposedCards.size(); j++) {
          //check to see for each card in the pyramid
          // if added to the exposed card is equal to 13 or is equal to 13
          if ((pileOfExposedCards.get(i).getNumberOfCard()) +
              pileOfExposedCards.get(j).getNumberOfCard() == 13 ||
              pileOfExposedCards.get(i).getNumberOfCard() == 13) {
            //returns the false because there are still possible moves
            return false;
          }
        }
      }
      //checks to see if the card in the exposed pile and the drawPile are equal to 13
      for (Card pileOfExposedCard : pileOfExposedCards) {
        for (int j = 0; j < getDrawCards().size(); j++) {
          if (pileOfExposedCard.getNumberOfCard() +
              getDrawCards().get(j).getNumberOfCard() == 13) {
            return false;
          }
        }
      }
    }
    return true;
  }


}
