package machine;
import java.util.Scanner;

enum State{
    WAIT, //waiting for user input
    BUY, FILL, TAKE, REMAINING, EXIT,  //action parts
    ESPRESSO, LATTE, CAPPUCCINO, //menu
    ADD_WATER, ADD_MILK, ADD_BEANS, ADD_CUPS, MONEY //add resources
}

public class CoffeeMachine {
    //initial values
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static State state;

    public static void printState() {
        System.out.println("\nThe coffee machine has:\n" +
                +water + " of water\n" +
                +milk + " of milk\n" +
                +beans + " of coffee beans\n" +
                +cups + " of disposable cups\n" +
                "$" + money + " of money");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        while (state != State.EXIT) {
            machineRunning(input.next());
        }
    }

    public static void machineRunning(String cur_state) {
        //change the state by the user input
        switch (cur_state) {
            case "remaining":
                state = State.REMAINING;
                break;
            case "buy":
                state = State.BUY;
                break;
            case "fill":
                state = State.FILL;
                break;
            case "take":
                state = State.TAKE;
                break;
            case "exit":
                state = State.EXIT;
                break;
            case "1":
                state = State.ESPRESSO;
                break;
            case "2":
                state = State.LATTE;
                break;
            case "3":
                state = State.CAPPUCCINO;
                break;

        }
        switch (state) {
            case BUY:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                break;
            case FILL:
                state = State.ADD_WATER;
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case ADD_WATER:
                System.out.println("Write how many ml of milk do you want to add:");
                water += Integer.parseInt(cur_state);
                state = State.ADD_MILK;
                break;
            case ADD_MILK:
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                milk += Integer.parseInt(cur_state);
                state = State.ADD_BEANS;
                break;
            case ADD_BEANS:
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                beans += Integer.parseInt(cur_state);
                state = State.ADD_CUPS;
                break;
            case ADD_CUPS:
                cups += Integer.parseInt(cur_state);
                state = State.WAIT;
                break;
            case TAKE:
                System.out.println("I gave you $" + money);
                money = 0;
                state = State.WAIT;
                break;
            case REMAINING:
                printState();
                state = State.WAIT;
                break;
            case EXIT:
                break;
            case ESPRESSO:
                //resources&price
                final int espresso_water = 250;
                final int espresso_beans = 16;
                final int espresso_price = 4;
                if (water - espresso_water < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans - espresso_beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= espresso_water;
                    beans -= espresso_beans;
                    cups -= 1;
                    money += espresso_price;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                state = State.WAIT;
                break;
            case LATTE:
                //resources&price
                final int latte_water = 350;
                final int latte_beans = 20;
                final int latte_milk = 75;
                final int latte_price = 7;
                if (water - latte_water < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans - latte_beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (milk - latte_milk < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= latte_water;
                    beans -= latte_beans;
                    cups -= 1;
                    milk -= latte_milk;
                    money += latte_price;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                state = State.WAIT;
                break;
            case CAPPUCCINO:
                //resources&price
                final int cappuccino_water = 200;
                final int cappuccino_beans = 12;
                final int cappuccino_milk = 100;
                final int cappuccino_price = 6;
                if (water - cappuccino_water < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans - cappuccino_beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (milk - cappuccino_milk < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    water -= cappuccino_water;
                    beans -= cappuccino_beans;
                    cups -= 1;
                    milk -= cappuccino_milk;
                    money += cappuccino_price;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                state = State.WAIT;
                break;
        }
        if(state==State.WAIT){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }
}
