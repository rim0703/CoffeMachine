public class GameRules {
    boolean gameOver;
    Character winner;
    public GameRules(){
        //create checking gameRules request
        gameOver = false;
        winner=' ';
    }

    public void game_rules(Character[][] store){
        //horizontal check
        for (int i = 0; i < 3; i++) {
            if (store[i][0] == store[i][1] && store[i][1] == store[i][2]) {
                if (store[i][0] == 'X') {
                    winner='X';
                    gameOver=true;
                    //System.exit(0);
                } else if (store[i][0] == 'O') {
                    winner='O';
                    gameOver=true;
                    //System.exit(0);
                }
            }
        }
        //vertical check
        for (int i = 0; i < 3; i++) {
            if (store[0][i] == store[1][i] && store[1][i] == store[2][i]) {
                if (store[0][i] == 'X') {
                    winner='X';
                    gameOver=true;
                    //System.exit(0);
                } else if (store[0][i] == 'O') {
                    winner='O';
                    gameOver=true;
                    //System.exit(0);
                }
            }
        }
        //cross check
        if (store[0][0] == store[1][1] && store[1][1] == store[2][2]) {
            if (store[1][1] == 'X') {
                winner='X';
                gameOver=true;
                //System.exit(0);
            } else if (store[1][1] == 'O') {
                winner='O';
                gameOver=true;
                //System.exit(0);
            }
        } else if (store[2][0] == store[1][1] && store[1][1] == store[0][2]) {
            if (store[1][1] == 'X') {
                winner='X';
                gameOver=true;
                //System.exit(0);
            } else if (store[1][1] == 'O') {
                winner='O';
                gameOver=true;
                //System.exit(0);
            }
        }

        //Game finished
        if(!gameOver){
            int gameOverCheck = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (store[i][j] != ' ') {
                        gameOverCheck++;
                        if(gameOverCheck==9){
                            //Draw:passed all the test
                            winner='D';
                            gameOver=true;
                            //System.exit(0);
                        }
                    }
                }
            }
        }
    }

    public boolean isGameOver(){
        return gameOver;
    }
    public Character getWinner(){
        return winner;
    }
    public void setWinner(){
        winner=' ';
    }
    public void printWinner(Character winner){
        if (winner == 'D') {
            System.out.println("Draw");
        } else if (winner == 'X') {
            System.out.println("X wins");
        } else if (winner == 'O') {
            System.out.println("O wins");
        }
    }
    public void setGameOver(boolean isOver){
        gameOver=isOver;
    }
}
