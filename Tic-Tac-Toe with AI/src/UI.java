public class UI {
    public static Character[][] store;
    public UI(){
        store = new Character[3][3];
    }
    public void clear_board(){
        System.out.println("---------");
        int pos=0;
        for(int i=0;i<3;i++) {
            System.out.print("| ");
            while (pos<i*3+3) {
                store[i][pos%3]=' ';
                System.out.print(store[i][pos%3]+" ");
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public void curr_board(Character[][] store){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(store[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void setStore(Character[][] store) {
        this.store = store;
    }

    public Character[][] getStore() {
        return store;
    }
}
