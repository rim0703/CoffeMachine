import java.util.Random;

public class AI_medium {
    private int count_O;
    private int count_X;
    public AI_medium(){
        // create a new medium level AI
        count_O=0;
        count_X=0;
    }
    public void AI_medium_steps(Character[][] store){
        // AI MEDIUM PART
        System.out.println("Making move level \"medium\"");
        Random rand = new Random();
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
            //horizontal check
            for(int i=0;i<3;i++){
                int check_O = 0;
                int check_X = 0;
                int check_position=-1;
                for(int j=0;j<3;j++){
                    if(store[i][j]==' '){
                        check_position = j;
                    }
                    if(store[i][j]=='X'){
                        check_X++;
                    }
                    else if(store[i][j]=='O'){
                        check_O++;
                    }
                    if(check_X==2&&check_position!=-1){
                        store[i][check_position]='X';
                        return;
                    }
                    else if(check_O==2&&check_position!=-1){
                        store[i][check_position]='X';
                        return;
                    }
                }
            }

            //vertical check
            for(int i=0;i<3;i++){
                int check_O = 0;
                int check_X = 0;
                int check_position=-1;
                for(int j=0;j<3;j++){
                    if(store[j][i]==' '){
                        check_position=j;
                    }
                    if(store[j][i]=='X'){
                        check_X++;
                    }
                    else if(store[j][i]=='O'){
                        check_O++;
                    }
                    if(check_X==2&&check_position!=-1){
                        store[check_position][i]='X';
                        return;
                    }
                    else if(check_O==2&&check_position!=-1){
                        store[check_position][i]='X';
                        return;
                    }
                }
            }
            //cross check
            //left corner to right corner
            int check_O = 0;
            int check_X = 0;
            int check_position=-1;
            for(int i=0;i<3;i++){
                if(store[i][i]==' '){
                    check_position=i;
                }
                if(store[i][i]=='X'){
                    check_X++;
                }
                else if(store[i][i]=='O'){
                    check_O++;
                }
                if(check_X==2&&check_position!=-1){
                    store[check_position][check_position]='X';
                    return;
                }
                else if(check_O==2&&check_position!=-1){
                    store[check_position][check_position]='X';
                    return;
                }
            }
            //right corner to left corner
            check_O = 0;
            check_X = 0;
            check_position=-1;
            for(int i=0;i<3;i++){
                if(store[i][2-i]==' '){
                    check_position=i;
                }
                if(store[i][2-i]=='X'){
                    check_X++;
                }
                else if(store[i][2-i]=='O'){
                    check_O++;
                }
                if(check_X==2&&check_position!=-1){
                    store[check_position][2-check_position]='X';
                    return;
                }
                else if(check_O==2&&check_position!=-1){
                    store[check_position][check_position]='X';
                    return;
                }
            }

            while(true){
                //passed all the test random position to set
                int num_x = rand.nextInt(3);
                int num_y = rand.nextInt(3);
                if(store[num_x%3][num_y%3]==' '){
                    store[num_x%3][num_y%3]='X';
                    break;
                }
            }


        }
        else{
            //horizontal check
            for(int i=0;i<3;i++){
                int check_O = 0;
                int check_X = 0;
                int check_position=-1;
                for(int j=0;j<3;j++){
                    if(store[i][j]==' '){
                        check_position = j;
                    }
                    if(store[i][j]=='X'){
                        check_X++;
                    }
                    else if(store[i][j]=='O'){
                        check_O++;
                    }
                    if(check_X==2&&check_position!=-1){
                        store[i][check_position]='O';
                        return;
                    }
                    else if(check_O==2&&check_position!=-1){
                        store[i][check_position]='O';
                        return;
                    }
                }
            }
            //vertical check
            for(int i=0;i<3;i++){
                int check_O = 0;
                int check_X = 0;
                int check_position=-1;
                for(int j=0;j<3;j++){
                    if(store[j][i]==' '){
                        check_position=j;
                    }
                    if(store[j][i]=='X'){
                        check_X++;
                    }
                    else if(store[j][i]=='O'){
                        check_O++;
                    }
                    if(check_X==2&&check_position!=-1){
                        store[check_position][i]='O';
                        return;
                    }
                    else if(check_O==2&&check_position!=-1){
                        store[check_position][i]='O';
                        return;
                    }
                }
            }
            //cross check
            //left corner to right corner
            int check_O = 0;
            int check_X = 0;
            int check_position=-1;
            for(int i=0;i<3;i++){
                if(store[i][i]==' '){
                    check_position=i;
                }
                if(store[i][i]=='X'){
                    check_X++;
                }
                else if(store[i][i]=='O'){
                    check_O++;
                }
                if(check_X==2&&check_position!=-1){
                    store[check_position][check_position]='O';
                    return;
                }
                else if(check_O==2&&check_position!=-1){
                    store[check_position][check_position]='O';
                    return;
                }
            }
            //right corner to left corner
            check_O = 0;
            check_X = 0;
            check_position=-1;
            for(int i=0;i<3;i++){
                if(store[i][2-i]==' '){
                    check_position=i;
                }
                if(store[i][2-i]=='X'){
                    check_X++;
                }
                else if(store[i][2-i]=='O'){
                    check_O++;
                }
                if(check_X==2&&check_position!=-1){
                    store[check_position][2-check_position]='O';
                    return;
                }
                else if(check_O==2&&check_position!=-1){
                    store[check_position][check_position]='O';
                    return;
                }
            }

            while(true){
                //passed all the test random position to set
                int num_x = rand.nextInt(3);
                int num_y = rand.nextInt(3);
                if(store[num_x%3][num_y%3]==' '){
                    store[num_x%3][num_y%3]='O';
                    break;
                }
            }
        }
    }
}
