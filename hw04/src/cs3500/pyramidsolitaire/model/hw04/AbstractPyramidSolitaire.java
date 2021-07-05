package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.SuitsofCards;
import cs3500.pyramidsolitaire.model.hw02.valueOfCards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An abstract class to avoid repetition.
 */
abstract public class AbstractPyramidSolitaire implements PyramidSolitaireModel<Card> {

  protected List<Card> deck;
  protected boolean shuffle;
  protected int numRows;
  protected int numDraw;

  protected List<List<Card>> pyramidList;
  protected List<Card> stock;

  /**
   * Constructs a {@link PyramidSolitaireModel} in a manner selected by concrete subclasses of this
   * class.
   *
   * @param deck    the full deck of cards
   * @param shuffle shuffles the cards
   * @param numRows represents the number of rows
   * @param numDraw represents the number of cards drawn
   */
  //DEFAULT constructor
  public AbstractPyramidSolitaire(List<Card> deck, boolean shuffle, int numRows, int numDraw) {

    this.shuffle = false;
    this.numRows = -1;
    this.numDraw = -1;
    this.pyramidList = new ArrayList<>();
    this.stock = null;
  }

  /**
   * Constructs a {@link PyramidSolitaireModel} in a manner selected by concrete subclasses of this
   * class.
   */
  //DEFAULT constructor
  public AbstractPyramidSolitaire() {
    this.deck = this.getDeck();
    this.shuffle = false;
    this.numRows = -1;
    this.numDraw = -1;
    this.pyramidList = new ArrayList<>();
    this.stock = null;
  }


  /**
   * Returns a complete deck.
   *
   * @return a list of cards
   */
  public List<Card> getDeck() {
    List<Card> listOfCards = new ArrayList<>();
    for (SuitsofCards suit : SuitsofCards.values()) {
      for (valueOfCards value : valueOfCards.values()) {
        // for (i = 1; i < 14; i++) {
        listOfCards.add(new Card(value, suit));
      }
    }
    return listOfCards;
  }

  /**
   * Returns a 2d ArrayList that is populated with the cards from the deck which represents the
   * pyramid.
   *
   * @return a 2d ArrayList
   */
  protected List<List<Card>> createPyramid() {
    List<List<Card>> pyramidList = new ArrayList<>();
    int index = 0;
    for (int i = 0; i < this.numRows; i++) {
      List<Card> newRow = new ArrayList<>();
      for (int j = 0; j < i + 1; j++) {
        newRow.add(deck.get(index)); //j
        index++;
      }
      pyramidList.add(newRow);
    }
    stock = deck.subList(index, deck.size());
    return pyramidList;
  }

  /**
   * Method determines if there are duplicates in list with hash codes.
   *
   * @param listOfCards represents the list of cards
   * @param <Card>      the type of cards
   * @return returns a true if there are duplicates
   */
  protected <Card> boolean haveDuplicatesTripletes(List<Card> listOfCards) {
    Set<Card> set = new HashSet<>();
    for (Card card : listOfCards) {
      if (set.contains(card)) {
        return true;
      }
      if (card != null) {
        set.add(card);
      }
    }
    return false;
  }

  /**
   * Method starts the game.
   *
   * @param deck    the deck to be dealt
   * @param shuffle if {@code false}, use the order as given by {@code deck}, otherwise use a
   *                randomly shuffled order
   * @param numRows number of rows in the pyramid
   * @param numDraw number of draw cards available at a time
   * @throws IllegalArgumentException if the deck is null or invalid. the number of pyramid rows or
   *                                  number of available draw cards is non-positive, or a full
   *                                  pyramid and draw pile cannot be dealt with the number of given
   *                                  cards in deck
   */

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
    } else if (deck.size() != 52) {
      throw new IllegalArgumentException("The deck is not the right size");
    }
    //does deck have duplicates
    else if (this.haveDuplicatesTripletes(deck)) {
      throw new IllegalArgumentException("This deck contains duplicates");
      //checks to make the sure number of rows is between 1 and 9
    } else if (numRows < 1 || numRows > 10) {
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
    this.pyramidList = createPyramid();

  }

  /**
   * Method determines if a specific card is exposed depending on the two cards below it.
   *
   * @return a boolean true if exposed false if not exposed
   */

  protected boolean isCardExposed(int row, int card) {
    //if this is the last row than it is exposed
    if (row == this.numRows - 1) {
      return true;
    }
    //if the card below are removed than it is exposed
    else {
      return this.getCardAt(row + 1, card) == null &&
          this.getCardAt(row + 1, card + 1) == null;
    }
  }


  /**
   * Method removes a card.
   *
   * @param row  row of the desired card position, numbered from 0 from the top of the pyramid
   * @param card card of the desired card position, numbered from 0 from left
   * @throws IllegalArgumentException if the attempted remove is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    if ((!this.isCardExposed(row, card))) {
      throw new IllegalArgumentException("the card is not exposed");
    } else if (this.numRows == -1) {
      throw new IllegalStateException("the game has not begun!");
    }
    //exception if row is below 0, invalid
    else if ((row > this.numRows || row < 0)) {
      throw new IllegalArgumentException("attempt is invalid because"
          + " the row number is below 0");
    } else if (card < 0 || card >= 13) {
      throw new IllegalArgumentException("card value is invalid!");
    } else if (this.pyramidList.get(row).get(card).getNumberOfCard() != 13) {
      throw new IllegalArgumentException("Cannot remove a non-king value by itself");
    }
    //check if the card is equal to 13 then remove
    Card removeCard1 = this.pyramidList.get(row).get(card);
    if (removeCard1.getNumberOfCard() == 13) {
      this.pyramidList.get(row).set(card, null);
      // this.stock.set(card, null);
    }
    // pyramidList.get(row).remove(card);
    // pyramidList.get(row).add(card, null);
  }

  /**
   * Removes two exposed cards on the pyramid.
   *
   * @param row1  row of first card position, numbered from 0 from the top of the pyramid
   * @param card1 card of first card position, numbered from 0 from left
   * @param row2  row of second card position
   * @param card2 card of second card position
   * @throws IllegalArgumentException when the attempt to remove is invalid
   * @throws IllegalStateException    when the game has not yet been started
   */

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    //exception if the game has not been started
    if (numDraw == -1) {
      throw new IllegalStateException("The game has not yet begun ");
    }
    //exception if the number rows is below
    else if (this.numRows == -1) {
      throw new IllegalStateException("The game has not yet begun");
    }
    //exception if the attempt to remove is invalid
    //if either card is not exposed
    //checks to see if the number of rows are in bound
    else if ((row1 > this.numRows - 1 || row1 < 0) && (row2 > this.numRows - 1 || row2 < 0)) {
      throw new IllegalArgumentException("The row number exceeds the number of rows "
          + "or the number of rows is smaller than 0 ");
    }
    //exception if the card value is out of bounds
    else if ((card2 < 0 || card1 < 0)) {
      throw new IllegalArgumentException("card value is invalid!");
    }
    Card removeCard1 = this.pyramidList.get(row1).get(card1);
    Card removeCard2 = this.pyramidList.get(row2).get(card2);
    if (removeCard1.getNumberOfCard() + removeCard2.getNumberOfCard() != 13) {
      throw new IllegalArgumentException("This removal is "
          + "invalid because the cards are not equal to 13");
    } else if (!(this.isCardExposed(row1, card1)) || !(this.isCardExposed(row2, card2))) {
      throw new IllegalArgumentException("This card "
          + "is not exposed");
    }
    //remove two exposed cards in the pyramid by setting their value to 0
    if (removeCard1.getNumberOfCard() + removeCard2.getNumberOfCard() == 13) {
      pyramidList.get(row1).remove(card1);
      pyramidList.get(row1).add(card1, null);
      pyramidList.get(row2).remove(card2);
      pyramidList.get(row2).add(card2, null);
    }
  }

  /**
   * removes a card from the draw list and the pyramid only does so if cards add to 13.
   *
   * @param drawIndex the card from the draw pile, numbered from 0 from left
   * @param row       row of the desired card position, numbered from 0 from the top of the pyramid
   * @param card      card of the desired card position, numbered from 0 from left
   * @throws IllegalArgumentException if the attempted remove is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    if (numRows == -1) {
      throw new IllegalStateException("The game has not begun");
    }
    if (drawIndex < 0 || drawIndex > stock.size()) {
      throw new IllegalArgumentException("The index is invalid");
    }
    if (row > this.numRows || row < 0) {
      throw new IllegalArgumentException("The row number exceeds the number of rows "
          + "or the number of rows is smaller than 0 ");
    }
    if (card < 0) {
      throw new IllegalArgumentException("card value is invalid!");
    }
    if (this.pyramidList.get(row).get(card).getNumberOfCard()
        + this.stock.get(drawIndex).getNumberOfCard() != 13) {
      throw new IllegalArgumentException("The cards do not sum to 13");
    }
    this.pyramidList.get(row).set(card, null);
    this.stock.remove(drawIndex);

  }


  /**
   * Removes the card from the draw pile and replaces it with a new card.
   *
   * @param drawIndex the card from the draw pile to be discarded
   * @throws IllegalArgumentException if the index is invalid or no card is present there.
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    if (this.numRows == -1) {
      throw new IllegalStateException("Game has not begun !");
    } else if (drawIndex < 0 || drawIndex > this.getDrawCards().size()) {
      throw new IllegalArgumentException("The index is invalid");
    }
    this.stock.remove(drawIndex);
    // this.stock.set(drawIndex, this.stock.get(drawIndex + 1));
  }

  /**
   * Returns the number of rows originally in the pyramid, or -1 if the game hasn't been started.
   *
   * @return the number of rows
   */
  @Override
  public int getNumRows() {
    if (this.numRows == -1) {
      return -1;
    }
    return this.numRows;
  }

  /**
   * Returns the maximum number of visible cards in the draw pile.
   *
   * @return returns the number visible cards
   */
  @Override
  public int getNumDraw() {
    if (this.numRows == -1) {
      return -1;
    }
    return this.numDraw;
  }

  /**
   * Returns the width of the requested row, measured from the leftmost card to the rightmost card
   * (inclusive) as the game is initially dealt.
   *
   * @param row the desired row (0-indexed)
   * @return the number of spaces needed to deal out that row
   * @throws IllegalArgumentException if the row is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public int getRowWidth(int row) {
    if (this.numRows == -1) {
      throw new IllegalStateException("the game has not begun !");
    }
    if ((row >= this.numRows || row < 0)) {
      throw new IllegalArgumentException("attempt is invalid because"
          + " the row number is below 0");
    }
    return this.pyramidList.get(row).size();
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

  /**
   * gets the score of the game by adding their number value.
   *
   * @return returns the score
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public int getScore() throws IllegalStateException {
    if (this.numRows == -1) {
      throw new IllegalStateException("The game has not begun");
    }
    int scoreOfGame = 0;
    for (List<Card> c : this.pyramidList) {
      for (Card ca : c) {
        if (ca != null) {
          scoreOfGame = ca.getNumberOfCard() + scoreOfGame;
        }
      }
    }
    return scoreOfGame;
  }

  /**
   * gets the location of a card.
   *
   * @param row  row of the desired card (0-indexed from the top)
   * @param card column of the desired card (0-indexed from the left)
   * @return returns the card at a specic location
   * @throws IllegalArgumentException if the coordinates are invalid
   * @throws IllegalStateException    if the game hasn't been started yet
   */
  @Override
  public Card getCardAt(int row, int card) throws IllegalStateException {
    if (this.numRows == -1) {
      throw new IllegalStateException("the game has not been started yet!");
    } else if ((row > this.numRows || row < 0)) {
      throw new IllegalArgumentException("attempt is invalid because"
          + " the row number is below 0 OR the row you've entered is greater"
          + " then the number of rows in the pyramid");
    } else if (card < 0 || card > getRowWidth(row)) {
      throw new IllegalArgumentException("card value is invalid!");
    }

    return this.pyramidList.get(row).get(card);
  }

  /**
   * gets the rest of the cards of the pyramid, so creates a draw pile.
   *
   * @return a list of cards left from the pyramid
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    if (this.numRows == -1) {
      throw new IllegalStateException("Game has not begun");
    }
    //makes a copy of the stock in order to not edit the stock directly
    //this.stock = new ArrayList<>(stock);

    return new ArrayList<>(this.stock.subList(0, Math.min(numDraw, this.stock.size())));
  }


}
