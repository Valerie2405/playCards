package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to represent the MultiPyramidSolitaire game class.
 */
public class MultiPyramidSolitaire extends AbstractPyramidSolitaire implements
    PyramidSolitaireModel<Card> {

  public MultiPyramidSolitaire() {
    super();
  }

  /**
   * Returns a complete deck.
   *
   * @return a list of cards
   */
  @Override
  public List<Card> getDeck() {
    List<Card> listOfCards = new ArrayList<>();
    for (SuitsofCards suit : SuitsofCards.values()) {
      for (valueOfCards value : valueOfCards.values()) {
        listOfCards.add(new Card(value, suit));
      }
    }
    //make a clone of the list of cards
    List<Card> listofCardsClone = new ArrayList<>(listOfCards);
    //add the cloned list to the list of cards
    listOfCards.addAll(listofCardsClone);
    //return the list of cards
    return listOfCards;
  }

  /**
   * Returns a 2d ArrayList that is populated with the cards from the deck which represents the
   * pyramid.
   *
   * @return a 2d ArrayList
   */
  protected List<List<Card>> createMultiPyramid() {
    List<List<Card>> multiPyramid = new ArrayList<>();
    int b = getBase(); //the number of the cards in the last row
    int m = Math.floorDiv(b, 4); //the index of the middle column
    int e = m * 2; // index of the last column

    int index = 0;
    for (int i = 0; i < numRows; i++) {
      List<Card> newRow = new ArrayList<>();
      for (int j = 0; j <= b - numRows + i; j++) {
        if (inAPyramid(i, j, 0)
            || inAPyramid(i, j, m)
            || inAPyramid(i, j, e)) {
          newRow.add(deck.get(index));
          index++;
        } else {
          newRow.add(null);
        }
      }
      multiPyramid.add(newRow);
    }
    stock = deck.subList(index, deck.size());
    return multiPyramid;
  }

  //returns the number of cards in the last column of a singular pyramid
  private int getBase() {
    if (numRows % 2 == 0) {
      return numRows * 2;
    } else {
      return numRows * 2 - 1;
    }
  }

  private boolean inAPyramid(int i, int j, int shift) {
    return (j >= shift) && (j < shift + i + 1);
  }

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw) {
    //CREATE COPY OF DECK HERE
    if (deck == null) {
      throw new IllegalArgumentException("the deck is null");
    } else {
      this.deck = new ArrayList<>(deck);
    }
    if (deck.isEmpty()) {
      throw new IllegalArgumentException("The deck is not the right size");
    } else if (deck.size() != 104) {
      throw new IllegalArgumentException("The deck is not the right size");
    }
    //does deck have duplicates
    else if (this.haveDuplicatesTripletes(deck)) {
      throw new IllegalArgumentException("This deck contains duplicates");
      //checks to make the sure number of rows is between 1 and 9
    } else if (numRows < 1 || numRows > 9) {
      throw new IllegalArgumentException("The number of rows is invalid");
      //Checks if the number of cards made available by the user is less than or equal to the amount
      //of cards left that are not in the pyramid
    } else if (numDraw < 0 || numDraw > (deck.size() - (numRows * (numRows + 1)) / 2)) {
      throw new IllegalArgumentException("The number of cards drawn is wrong");
    }
    //shuffle deck of cards
    //copy paste elements from one list to another list
    if (shuffle) {
      Collections.shuffle(this.deck);
    }

    this.numRows = numRows;
    this.numDraw = numDraw;
    this.pyramidList = createMultiPyramid();

  }


  /**
   * Method determines if there are duplicates in list with hash codes.
   *
   * @param listOfCards represents the list of cards
   * @param <Card>      the type of cards
   * @return returns true if there are triplets
   */
  @Override
  protected <Card> boolean haveDuplicatesTripletes(List<Card> listOfCards) {
    for (int i = 0; i < listOfCards.size() - 2; i++) {
      for (int j = i + 1; j < listOfCards.size() - 1; j++) {
        for (int k = j + 1; k < listOfCards.size(); k++) {
          if (listOfCards.get(i) == listOfCards.get(j) && listOfCards.get(j) == listOfCards
              .get(k)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
