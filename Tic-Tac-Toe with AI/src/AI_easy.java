import java.util.Random;

public class AI_easy {
    private int count_O;
    private int count_X;

    public AI_easy(){
        // create a new easy level AI
        count_O=0;
        count_X=0;

    }
    public void AI_easy_steps(Character[][] store){
        System.out.println("Making move level\"easy\"");
        Random rand = new Random();
        count_O=0;
        count_X=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //System.out.println(store[i][j]);
                if(store[i][j]=='X'){
                    count_X++;
                }
                else if(store[i][j]=='O'){
                    count_O++;
                }
            }
        }

        while(true){
            int num_x = rand.nextInt(3);
            int num_y = rand.nextInt(3);
            if(store[num_x%3][num_y%3]==' '){
                if(count_X<=count_O){
                    store[num_x%3][num_y%3] = 'X';
                }
                else if(count_O<count_X){
                    store[num_x%3][num_y%3] = 'O';
                }
                break;
            }
        }

    }
}
