package standard;
import java.util.ArrayList;

public class N_queens {
    private int N;
    private int cols[]; //cols[i] = i행의 col 좌표

    public N_queens(int N){
        this.N = N;
        cols = new int[N];
    }

    public void back_tracking(int level){
        if(level == N){
            for(int i=0;i<N;i++){
                System.out.print(cols[i] + " ");
            }
            System.out.println("");
        } else{
            for(int i=0;i<N;i++){
                cols[level]=i;
                if(isPossible(level)){
                    back_tracking(level+1);
                }
            }
        }
    }

    public boolean isPossible(int level){
        for(int i=0;i<level;i++){
            if(cols[i] == cols[level] || Math.abs(level-i) == Math.abs(cols[level]-cols[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 5;
        N_queens queen = new N_queens(N);
        queen.back_tracking(0);
    }
}