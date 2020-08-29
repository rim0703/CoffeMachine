Tic-Tac-Toe with AI
=============
 
About
-------
Everybody remembers this paper-and-pencil game from childhood: Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. A single mistake usually costs you the game, but thankfully it is simple enough that most players discover the best strategy quickly.

This program implements that a user can fight with 3 levels(<b>easy, medium, hard</b>) of the computer(AI) also with another user.
#### Command guideline
 - #### Start the game: 
 
    You will get "Input command: " instructions, when you start the game. 
    
    You should enter as below format:
    
        Input command: start [player1] [player2]

    So if you want to play with a medium level AI, you should enter the command like:
    
        Input command: start user medium

    Or you want to see two AIs(medium level & hard level) automatically play the game:
    
        Input command: start medium hard
        
 - #### Control the game:
    
    AI(computer) will automatically put their Xs or Os in their turn.
    
    When users turn, user should input coordinate numbers as below (same as X,Y coordinates).
    
        /*initial gameboard*/            /*coordinate*/
              -------              ↑Y----------------------
              |x x x|           3  |   |(1,3) (2,3) (3,3)|
              |x x x|           2  |   |(1,2) (2,2) (3,2)|
              |x x x|           1  |   |(1,1) (2,1) (3,1)|
              -------              |---------------------->X
                                          1     2     3
    You will get "Enter the coordinates: " instruction, then you should enter 2 numbers as above guidelines.
    
    For example, <b>2nd-row 3rd-column (split numbers with a space)</b>:
    
        Enter the coordinates: 3 2
 - #### End the game:
    If the game finished, it will return to the GameStart commands and 
    you will get "Input command: " instruction again to start a new game.
    
    If you want to exit the game, input "exit" :
    
        Input command: exit
    
Learning outcomes
--------
After finishing this project, you'll get to know a lot about planning and developing a complex program from scratch, using classes and methods, handling errors, and processing user input. You will also learn to use OOP (Object-Oriented Programming) in the process.

Reference 
-----------
 - JetBrains Academy / Hyperskill 
 - Java Developer
