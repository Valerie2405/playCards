package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the controller of the game.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {

  private final Scanner scan;
  private PyramidSolitaireView view;
  // private BasicPyramidSolitaire model;
  private boolean quitGameBool;
  final private Appendable ap; //output

  /**
   * Represents the constructor of the controller.
   *
   * @param rd represents the readable, (input).
   * @param ap represents the appendable, (output).
   * @throws IllegalArgumentException the appendable is null.
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
      throws IllegalArgumentException {
    this.ap = ap;
    if (this.ap == null) {
      throw new IllegalArgumentException("The appendable is null");
    }
    if (rd == null) {
      throw new IllegalArgumentException("The readable is null");
    }

    this.scan = new Scanner(rd);

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
      int numRows, int numDraw) throws IllegalArgumentException {
    try {
      if (model == null || deck == null) {
        throw new IllegalArgumentException("Model is null");
      } else {
        model.startGame(deck, shuffle, numRows, numDraw);
      }

      //creates a new view so the controller can call on it
      this.view = new PyramidSolitaireTextualView(model, ap);

      //creates a new model so the controller can call on it, don't need it because model is a
      // param
      // this.model = new BasicPyramidSolitaire();
      //transmit game state to appendable + transmit score

      try {
        view.render();
        if (model.isGameOver()) {
          return;
        }
        this.ap.append("\nScore: ").append(String.valueOf(model.getScore())).append("\n");

      } catch (IOException e) {
        throw new IllegalStateException("Could not render Input");
      }

      try {

        //TWO CONDITIONS FOR THE Loop to continue: if the game is NOT over and if the user
        // has more to input
        while (!model.isGameOver() && scan.hasNext()) {

          //there are more moves + game is still in progress
          String nextInput = scan.next();

          switch (nextInput) { //always assign scan.next to a variable
            //case:
            case "rm1":
              remove1Helper(model);
              break;
            case "rm2":
              remove4Helper(model);
              break;
            case "rmwd":
              remove3DrawHelper(model);
              break;
            case "dd":
              discardDrawHelper(model);
              break;
            //case if the game is quit
            case "Q":
            case "q":
              quitGameString(model);
              return;
            //unrecognized input
            default:
              ap.append("unrecognized input:").append(nextInput);
              ap.append("\n");

          }
          if (quitGameBool) {
            quitGameString(model);
            return;
          }

          view.render();
          this.ap.append("\n");
        }

      } catch (IOException e) {
        //
      }

    } catch (IllegalStateException e) {
      throw new IllegalStateException("Illegal argument here please try again !");
    }

  }

  /**
   * Helper for the input "rm1", calls remove on the two inputs provided by the user.
   *
   * @param model the model of the game.
   * @throws NumberFormatException if the rendering fails for some reason.
   */
  private void remove1Helper(PyramidSolitaireModel model)
      throws NumberFormatException, IOException {
    List<Integer> inputList = new ArrayList<>();
    while (inputList.size() != 2) {
      String input1 = scan.next();
      try {
        int inputint1 = Integer.parseInt(input1);
        inputList.add(inputint1);
      } catch (NumberFormatException e) {
        //handles a good (q) or bad input
        if (input1.equalsIgnoreCase("q")) {
          this.quitGameBool = true;
          return;
        }
      }

    }
    try {
      model.remove(inputList.get(0) - 1, inputList.get(1) - 1);
    } catch (IllegalArgumentException e) {
      this.ap.append(e.getMessage() + "\n");
    }
  }

  /**
   * Helper for the input "rm2", calls remove on the four inputs provided by the user.
   *
   * @param model the model of the game.
   * @throws NumberFormatException if the rendering fails for some reason.
   */

  private void remove4Helper(PyramidSolitaireModel model)
      throws NumberFormatException, IOException {
    List<Integer> inputList = new ArrayList<>();
    while (inputList.size() != 4) {
      String input1 = scan.next();
      try {
        int inputint1 = Integer.parseInt(input1);
        inputList.add(inputint1);
      } catch (NumberFormatException e) {
        //handles a good (q) or bad input
        if (input1.equalsIgnoreCase("q")) {
          this.quitGameBool = true;
          return;
        }
      }

    }

    try {
      model.remove(inputList.get(0) - 1, inputList.get(1) - 1,
          inputList.get(2) - 1, inputList.get(3) - 1);
    } catch (IllegalArgumentException e) {
      this.ap.append(e.getMessage() + "\n");
    }


  }

  private void remove3DrawHelper(PyramidSolitaireModel model)
      throws NumberFormatException, IOException {
    List<Integer> inputList = new ArrayList<>();
    while (inputList.size() != 3) {
      String input1 = scan.next();
      try {
        int inputint1 = Integer.parseInt(input1);
        inputList.add(inputint1);
      } catch (NumberFormatException e) {
        //handles a good (q) or bad input
        if (input1.equalsIgnoreCase("q")) {
          this.quitGameBool = true;
          return;
        }
      }

    }
    try {
      model.removeUsingDraw(inputList.get(0) - 1, inputList.get(1) - 1,
          inputList.get(2) - 1);
    } catch (IllegalArgumentException e) {
      this.ap.append(e.getMessage() + "\n");
    }
  }

  private void discardDrawHelper(PyramidSolitaireModel model) throws IOException {
    List<Integer> inputList = new ArrayList<>();
    while (inputList.size() != 1) {
      String input1 = scan.next();
      try {
        int inputint1 = Integer.parseInt(input1);
        inputList.add(inputint1);
      } catch (NumberFormatException e) {
        //handles a good (q) or bad input
        if (input1.equalsIgnoreCase("q")) {
          this.quitGameBool = true;
          return;
        }
      }

    }

    try {
      model.discardDraw(inputList.get(0) - 1);
    } catch (IllegalArgumentException e) {
      this.ap.append(e.getMessage() + "\n");
    }

  }

  //helper: Creates string in order to quit game
  void quitGameString(PyramidSolitaireModel model) throws IOException {
    this.ap.append("Game quit!\nState of game when quit\n");
    this.view.render();
    this.ap.append("\n");
    this.ap.append(String.format("Score: %d", model.getScore()));
    return;
  }
}


