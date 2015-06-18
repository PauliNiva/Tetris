Testing Document:

I have used automatic tests (JUnit and Mockito) and manual testing to test the functionality of the game.
Manual testing has included but was not limited to:
- Playing the game.
- Rotating the pieces wildly by keeping the the rotation button pressed as the piece makes contact with other pieces.
- Counting that the score keeping works as it should.
- Visually confirming that the Tetrimino that is drawn to appear next does indeed appear next.
- Randomly bashing the keys on the keyboard to try to make the game crash or do something unexpected.
- Using the keys to move and rotate the piece alternatively to see if strange behavior occurs when contacting the
  playing field borders or other pieces.
  

Found bugs:

FIXED   Rotating piece rotates over another piece if the occupied cell is to the side of rotating piece.
FIXED   Wildly rotating piece sometimes eats another pieces away from the playing field. 