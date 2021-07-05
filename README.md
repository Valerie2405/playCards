 # playCards

There are three versions of this card game :

- BasicaPyramidSolitaire
- MultiPyramidSolitaire
- RelaxedPyramidSolitaire

To play the game:

Create a new configuration
- Main class textbox enter: cs3500.pyramidsolitaire.PyramidSolitaire
- Argument Box enter command line argumets:
  - for Basic pyramid : basic 7 3
  - for Relaxed pyramid: relaxed 6 2
  - for multipyramid : 7 8

Possible commands:
- rm1 followed by row and column numbers of card (removes the card at the location provided : rox x column)
  - e.g. rm1 7 7 
- rm2 followed by row and column numbers of cards (removes two cards at both locations provided)
  - e.g. rm2 7 1 7 3
- rmwd followed by number of the draw card and row and column (number of draw card and the row and column in the pyramid)
   - e.g. rmwd 1 7 4
 - dd followed by the number of the draw card to be discarded
    - e.g. dd 1 
- 'q' OR 'Q' the game will end
 Design Patter Used: MVC
