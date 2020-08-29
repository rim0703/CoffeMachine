import java.util.Random;

public class AI_hard {
    private int count_O;
    private int count_X;
    private GameRules rules;
    public AI_hard(){
        count_O=0;
        count_X=0;
        rules=new GameRules();
    }

    public void AI_hard_steps(Character[][] store) {
        // AI HARD PART
        System.out.println("Making move level \"hard\"");
        Random rand = new Random();
        count_O = 0;
        count_X = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (store[i][j] == 'X') {
                    count_X++;
                } else if (store[i][j] == 'O') {
                    count_O++;
                }
            }
        }
        int record_X = count_X;
        int record_O = count_O;
        int bestscore = -100;
        int pos_x = 0;
        int pos_y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int score = 0;
                //gameOver=false;
                count_X = record_X;
                count_O = record_O;
                if (store[i][j] == ' ') {
                    if (count_X > count_O) {
                        store[i][j] = 'X';
                        score = minimax(store, 0, false);
                        rules.game_rules(store);
                        if (rules.getWinner() == 'X') {//check if the game is finished and return value
                            score = 1;//win
                        } else if (rules.getWinner() == 'O') {
                            score = -1;//lose
                        } else if (rules.getWinner() == 'D' || rules.getWinner() == ' ') {
                            score = 0;
                        }
                        store[i][j] = ' ';
                    } else {
                        store[i][j] = 'O';
                        score = minimax(store, 0, true);
                        rules.game_rules(store);
                        if (rules.getWinner() == 'X') {//check if the game is finished and return value
                            score = -1;//lose
                        } else if (rules.getWinner() == 'O') {
                            score = 1;//win
                        } else if (rules.getWinner() == 'D' || rules.getWinner() == ' ') {
                            score = 0;
                        }
                        //System.out.println(score + " "+bestscore);
                        store[i][j] = ' ';

                    }
                    //System.out.println("score:"+score+" best:"+bestscore+" winner: "+rules.getWinner());
                    if (score > bestscore) {
                        //System.out.println("CHECKED!");
                        bestscore = score;
                        pos_x = i;
                        pos_y = j;
                    }

                }
            }
        }
        /*if (record_X == 0 && record_O == 0) {
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            store[x][y] = 'X';
        }*/
        if (record_X <= record_O) {
            store[pos_x][pos_y] = 'X';
        } else {
            store[pos_x][pos_y] = 'O';
        }
        rules.setGameOver(false);
        rules.setWinner();
    }


    public int minimax(Character[][] store, int depth, boolean isMaximizing) {
        count_O = 0;
        count_X = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (store[i][j] == 'X') {
                    count_X++;
                } else if (store[i][j] == 'O') {
                    count_O++;
                }
            }
        }
        int bestscore;
        if (isMaximizing) {
            //int score=0;
            bestscore = -100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (store[i][j] == ' ') {
                        if (count_X <= count_O) {
                            store[i][j] = 'X';
                        } else {
                            store[i][j] = 'O';
                        }
                        int score = minimax(store, depth + 1, false);
                        store[i][j] = ' ';
                        bestscore = Math.max(score, bestscore);
                    }
                }
            }
        } else {
            //int score = 0;
            bestscore = 100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (store[i][j] == ' ') {
                        if (count_X <= count_O) {
                            store[i][j] = 'X';
                        } else {
                            store[i][j] = 'O';
                        }
                        int score = minimax(store, depth + 1, true);
                        store[i][j] = ' ';
                        bestscore = Math.min(score, bestscore);
                    }
                }
            }
        }
        return bestscore;
    }
}
