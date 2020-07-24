package tictactoe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------");
        int pos=0;
        Character[][] store = new Character[3][3];
        for(int i=0;i<3;i++) {
            System.out.print("| ");
            while (pos<i*3+3) {
                System.out.print("  ");
                store[i][pos%3]=' ';
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");

        /* Game Start! */
        boolean gameOver = false;
        int steps=1;

        while (gameOver==false) {
            int coord_1 = 0;
            int coord_2 = 0;
            while (true) {
                System.out.print("Enter the coordinates: ");
                try {
                    String input = sc.nextLine();
                    String[] coord = input.split(" ");
                    coord_1 = Integer.parseInt(coord[0]);
                    coord_2 = Integer.parseInt(coord[1]);
                    if (coord_1 < 1 || coord_1 > 3 || coord_2 < 1 || coord_2 > 3) {
                        throw new IllegalAccessException();
                    }
                    if(store[3 - coord_2][coord_1 - 1] != ' '){
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                } catch (IllegalAccessException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } catch (IllegalArgumentException e){
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }


            if(steps%2==1){
                store[3 - coord_2][coord_1 - 1] = 'X';
                steps++;
            }
            else if(steps%2==0){
                store[3 - coord_2][coord_1 - 1] = 'O';
                steps++;
            }



            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(store[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");


            /* Game Rule Algorithm */
            //impossible
            int count_X = 0;
            int count_O = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (store[i][j] == 'X') {
                        count_X++;
                    } else if (store[i][j] == 'O') {
                        count_O++;
                    }
                }
            }
            if (count_X > count_O + 1 || count_O > count_X + 1) {
                System.out.println("Impossible -1");
                System.exit(0);
            }
            count_X = 0;
            count_O = 0;
            //horizontal impossible
            for (int i = 0; i < 3; i++) {
                if (store[i][0] == store[i][1] && store[i][1] == store[i][2]) {
                    if (store[i][0] == 'X') {
                        count_X += 3;
                    } else if (store[i][0] == 'O') {
                        count_O += 3;
                    }
                }
                if (count_O == count_X && count_O != 0) {
                    System.out.println("Impossible");
                    System.exit(0);
                }
            }
            count_X = 0;
            count_O = 0;
            //vertical impossible
            for (int i = 0; i < 3; i++) {
                if (store[0][i] == store[1][i] && store[1][i] == store[2][i]) {
                    if (store[0][i] == 'X') {
                        count_X += 3;
                    } else if (store[0][i] == 'O') {
                        count_O += 3;
                    }
                }
                if (count_O == count_X && count_O != 0) {
                    System.out.println("Impossible");
                    System.exit(0);
                }
            }


            //horizontal check
            for (int i = 0; i < 3; i++) {
                if (store[i][0] == store[i][1] && store[i][1] == store[i][2]) {
                    if (store[i][0] == 'X') {
                        System.out.println("X wins");
                        System.exit(0);
                    } else if (store[i][0] == 'O') {
                        System.out.println("O wins");
                        System.exit(0);
                    }
                }
            }
            //vertical check
            for (int i = 0; i < 3; i++) {
                if (store[0][i] == store[1][i] && store[1][i] == store[2][i]) {
                    if (store[0][i] == 'X') {
                        System.out.println("X wins");
                        System.exit(0);
                    } else if (store[0][i] == 'O') {
                        System.out.println("O wins");
                        System.exit(0);
                    }
                }
            }
            //cross check
            if (store[0][0] == store[1][1] && store[1][1] == store[2][2]) {
                if (store[1][1] == 'X') {
                    System.out.println("X wins");
                    System.exit(0);
                } else if (store[1][1] == 'O') {
                    System.out.println("O wins");
                    System.exit(0);
                }
            } else if (store[2][0] == store[1][1] && store[1][1] == store[0][2]) {
                if (store[1][1] == 'X') {
                    System.out.println("X wins");
                    System.exit(0);
                } else if (store[1][1] == 'O') {
                    System.out.println("O wins");
                    System.exit(0);
                }
            }

            //Game finished
            int gameOverCheck = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (store[i][j] != ' ') {
                        gameOverCheck++;
                        if(gameOverCheck==9){
                            //Draw:passed all the test
                            System.out.println("Draw");
                            break;
                        }
                    }
                }
            }
        }
    }
}
