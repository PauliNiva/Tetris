Subject of the Project: Game of Tetris.

Tetris is a tile-matching puzzle game, where the player tries to tile falling Tetromino blocks (called Tetriminoes in the game)
so that the blocks form solid rows. Player can manipulate Tetriminoes, by moving them sideways and rotating them 90 degrees
with each rotation. When a row is filled, it disappears from the playing field and any block over the disappearing line
will fall. If a player manages to fill four rows at the same time, that is called a "Tetris".

After certain amount of cleared rows the game enters to a new level and the rate at which the Tetriminoes descent increases.
Game cannot be paused because that can be used as a mechanism for cheating (by giving player time to think where he/she
should place the falling Tetriminoe).
Game ends when the tiled Tetrimino blocks reaches such height that new Tetrimino block that is entering the playing field
does not have a room to fall completely into the field.

Users: Player (anyone interested in playing the game).

Actions of the player:
  - Moving Tetrimino blocks to the left and right.
  - Instant dropping of the Tetrimino block to the bottom of the playing field.
  - Rotating Tetrimino blocks 90 degrees at a time.
  - Starting a new game when an old one is finished.

Functionality of the game:
  - Creating Tetrimino blocks in random sequence.
  - Score keeping.
  - Removal of full rows.
  - Showing the next Tetrimino block that is going to appear in the playing field.
  - Lifting the level of difficulty (by increasing the speed that the tetriminoes fall down the playing field) after every 10 rows removed.
  
Structure of the program:

Main class creates starter (used for easier main method testing), which in turn creates a game manager.
Game manager creates a listener for the user input. It also creates GUI for a playing field and attaches the GUI and the listener to
a JFrame. After that it starts the game with start method, which keeps the game running after the game over state is reached.

  When the GUI for the playing field is created, it in turn creates a GUI for the cells that make up the playing field.
It also creates the playing field which creates a bunch of objects. It creates the score counter and Tetrimino piece generator.
Also it creates the cells that makeup the playing field and a mapper that maps the movement and rotations of the the Tetrimino pieces
in the playing field.

  Mapper maps the pieces on the board as to if they occupy a certain cell or not. It uses the rotator to determine where the piece ends up
after the rotation. It also checks that the rotating piece does not overlap another pieces that are already on the field.

  When a player presses a valid key on keyboard, the listener picks that up and orders the piece to move by chaining. First it calls the
playing field GUI, which calls the playing field, which calls the mapper, which asks from a validator if the move or rotation is valid.
This is done is case of rotation in a manner where the mapper asks the rotator to rotate the piece to see where it would end up. If it
does not end up occupying any cells that are already occupied or if the piece ís not going to rotate of the playing field, then it allows
the rotation to be made and maps the new location of the piece. Then it asks the playing field to tick (which is the internal clock unit
of the game). Playing field keeps tracks of the ticks through ticklistener interface.

  When so many pieces occupy the playing field that a new Tetrimino piece does not fit in the playing field, then the playing field
tells the playing field GUI that the game is over, which in turn informs the game manager that the game is over. Then the game manager
removes all elements from the JFrame and disposes itself, thus ending the game and shutting the program down.
