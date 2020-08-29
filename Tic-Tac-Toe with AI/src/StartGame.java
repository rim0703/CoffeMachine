import java.util.Scanner;

public class StartGame {
    Character[][] store;
    public StartGame(){
        // control starting
        store = new UI().getStore();
    }
    public void start_fight() {
        System.out.print("Input command: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] pare = str.split(" ");
        if(pare[0].equals("exit")){
            System.exit(0);
        }
        if (pare[0].equals("start")&&pare.length==3) {
            UI ui = new UI();
            AI_easy easy= new AI_easy();
            AI_medium medium = new AI_medium();
            AI_hard hard = new AI_hard();
            GameRules rules = new GameRules();
            User user = new User();
            if (pare[1].equals("easy") && pare[2].equals("easy")) {
                //AI VS AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    easy.AI_easy_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                }
                rules.printWinner(rules.getWinner());

            } else if (pare[1].equals("easy") && pare[2].equals("user")) {
                //AI VS USER
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    easy.AI_easy_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if(!rules.isGameOver()){
                        user.user_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if (pare[1].equals("user") && pare[2].equals("easy")) {
                //USER VS AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    user.user_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if(!rules.isGameOver()) {
                        easy.AI_easy_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if ((pare[1].equals("user") && pare[2].equals("user"))) {
                //USER VS USER
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    user.user_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                }
                rules.printWinner(rules.getWinner());
            }
            else if((pare[1].equals("user")&&pare[2].equals("medium"))){
                //USER VS MEDIUM AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    user.user_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if(!rules.isGameOver()){
                        medium.AI_medium_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if((pare[1].equals("medium")&&pare[2].equals("user"))){
                //MEDIUM AI vs USER
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    medium.AI_medium_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if(!rules.isGameOver()){
                        user.user_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if((pare[1].equals("easy")&&pare[2].equals("medium"))){
                //EASY AI VS MEDIUM AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    easy.AI_easy_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if(!rules.isGameOver()) {
                        medium.AI_medium_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if((pare[1].equals("medium")&&pare[2].equals("easy"))){
                //MEDIUM AI vs EASY AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    medium.AI_medium_steps(store);;
                    ui.curr_board(store);;
                    rules.game_rules(store);
                    if(!rules.isGameOver()) {
                        easy.AI_easy_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
            else if((pare[1].equals("medium")&&pare[2].equals("medium"))){
                //MEDIUM AI VS MEDIUM AI
                ui.clear_board();
                store=ui.getStore();
                while(!rules.isGameOver()){
                    medium.AI_medium_steps(store);;
                    ui.curr_board(store);;
                    rules.game_rules(store);
                }
                rules.printWinner(rules.getWinner());
            }
            else if ((pare[1].equals("hard") && pare[2].equals("user"))) {
                //HARD AI VS USER
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    hard.AI_hard_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        user.user_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("hard") && pare[2].equals("hard"))) {
                //HARD AI VS HARD AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    hard.AI_hard_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("user") && pare[2].equals("hard"))) {
                //USER VS HARD AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    user.user_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        hard.AI_hard_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("easy") && pare[2].equals("hard"))) {
                //EASY AI VS HARD AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    easy.AI_easy_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        hard.AI_hard_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("hard") && pare[2].equals("easy"))) {
                //HARD AI VS EASY AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    hard.AI_hard_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        easy.AI_easy_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("medium") && pare[2].equals("hard"))) {
                //MEDIUM AI VS HARD AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    medium.AI_medium_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        hard.AI_hard_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            } else if ((pare[1].equals("hard") && pare[2].equals("medium"))) {
                //HARD AI VS MEDIUM AI
                ui.clear_board();
                store=ui.getStore();
                while (!rules.isGameOver()) {
                    hard.AI_hard_steps(store);
                    ui.curr_board(store);
                    rules.game_rules(store);
                    if (!rules.isGameOver()) {
                        medium.AI_medium_steps(store);
                        ui.curr_board(store);
                        rules.game_rules(store);
                    }
                }
                rules.printWinner(rules.getWinner());
            }
        }
        else{
            System.out.println("Bad parameters!");
            start_fight();
        }

    }
}
