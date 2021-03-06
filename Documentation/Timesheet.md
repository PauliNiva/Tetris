- 08.05.2015 17.30 - 18.00 (30 min.):
	Read through the course page, initialized a repository for the project in the GitHub and registered to the Labtool.
- 09.05.2015 09.30 - 10.00 (30 min.):
	Started timekeeping, Initial project setup (updated gitignore and readme, made the pom-file and checkstyle rules for the project).
- 11.05.2015 18.25 - 18.45 (20 min.):
	Added document describing the the project.
- 13.05.2015 20.55 - 21.05 (10 min.):
	Setting up travis, minor pom changes.
- 17.05.2015 09.00 - 12.30 (3 h. 30 min.):
	General planning of the architecture and what functionality is going to be implemented this week.
- 18.05.2015 15.00 - 17.20 (2 h. 20 min.):
	Made all the Tetrimino-piece classes and started working on the playing field and the boxes that make up the playing field.
- 19.05.2015 12.00 - 19.00 (7 h.):
	Refactored already made classes, made some new ones and also started to make tests for the program.
- 20.05.2015 12.00 - 18.15 (6 h. 15 min.):
	Drew the class diagram (and refreshed my UML knowledge with reading about it), and wrote some tests.
- 24.05.2015 09.00 - 17.00 (8 h.):
	Made GUI for cells and playing field and added bunch of stuff to another classes.
- 25.05.2015 12.00 - 17.00 (5 h.):
	Spent all day debugging why Tetriminoes would not fall down in playing field as they should.
- 26.05.2015 12.00 - 18.00 (6 h.):
	Pondered why it's still not working. Had an "eureka" moment and then pondered how to implement the solution and finally fixed the problem.
- 27.05.2015 12.00 - 16.00 (4 h.):
	Spent whole day making JUnit tests.
- 28.05.2015 16.30 - 17.05 (35 min.):
	Updated the class diagram to correspond with the changes that were made during a week.
- 02.06.2015 12.00 - 21.15 (9 h. 15 min.):
	After being sick for a couple of days, it's back to the drawing board. Made a listener for user inputs (so the user can move tetriminoes
	around) and tests for it. Spent half a day wondering and swearing why robot for simulating keystrokes in tests wasn'tworking even
	though it should have. Found out by accident that the problem was that the thread.sleep between key.pressed and key.released wasn't
	adequately long (value was 50), so the key press didn't have enough time to be registered.
- 03.06.2015 10.00 - 16.00 (6 h.):
	Added a functionality for rotating the Tetrimino pieces and made few basic tests for it. Because Mapper class was getting quite inflated,
	I refactored Rotation functionality to three classes. Some I left in mapper, actual rotation of Tetrimino containers to a new class called
	Rotators and validation methods for rotating the piece to a new class called RotationValidator.
- 04.06.2015 10.00 - 17.30 (7 h. 30 min.):
	Added Mockito to the project and few mocks. Also added some JUnit tests. Updated class diagram and added two sequence diagrams.
- 07.06.2015 12.00 - 15.30 (3 h. 30 min.):
	Added functionality to show the next Tetrimino piece that is going to appear in the playing field.
- 08.06.2015 12.00 - 13.00 (1 h.):
	Added the functionality for increasing the difficulty of game play. Also changed the base color of the playing field from white to gray
	to make the Tetrimino pieces more visible.
- 09.06.2015 13.00 - 16.00 (3 h.):
	Added score keeping functionality to the program and some refactoring.
- 11.06.2015 12.00 - 17.30 (5 h. 30 min.):
	Updated the class the diagram and made a new sequence diagram depicting what happens when a row is completed. Also spent most of the day
	trying to figure out how to make restarting the game convenient with swing (ergo, spent time reading about swing). I was not happy with the
	implementation that I came up, so I decided not to push it. Will try again tomorrow with a fresh mind.
- 17.06.2015 10.00 - 19.00 (9 h.):
	Had to study for combinatorics-exam earlier this week and on weekend, so today was supposed to be a big push day, but at a start of a day
	I founded a bug in the program. If you pushed rotate button to bottom and kept it there, the spinning Tetrimino would eat other Tetriminoes
	away from the playing field. So obviously there was something very wrong with the collision check when rotating the piece. Don't know how
	that went on missed for this long. So I spent a whole day hunting that bug, instead of implementing a proper start and start again features
	that where on my todo list. Tomorrow I have an exam and tutkijalinja-meeting. So unless a miracle happens and I find some strength after those,
	otherwise this thing is about done.
- 18.06.2015 08.00 - 08.45 (45 min.):
	Made the last necessary documents, updated java docs, pit report and made a new release. Also made some checkstyle corrections.
- 18.05.2015 11.55 - 12.45 (50 min.):
	Found another bug and squashed it.
	