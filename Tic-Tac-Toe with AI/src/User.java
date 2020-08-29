import java.util.Scanner;

public class User {
    private int coord_1;
    private int coord_2;
    private int count_O;
    private int count_X;

    public User(){
        coord_1 = 0;
        coord_2 = 0;
        count_O = 0;
        count_X = 0;
    }

    public void user_steps(Character[][] store){
        while (true) {
            Scanner sc = new Scanner(System.in);
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

        count_O=0;
        count_X=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(store[i][j]=='X'){
                    count_X++;
                }
                else if(store[i][j]=='O'){
                    count_O++;
                }
            }
        }
        if(count_X<=count_O){
            store[3 - coord_2][coord_1 - 1] = 'X';
        }
        else if(count_O<count_X){
            store[3 - coord_2][coord_1 - 1] = 'O';
        }
    }

}
