package backjoon;
import java.util.Scanner;
public class N_queens {
    private int N;
    private int cols[]; //cols[i] = i행의 col 좌표
    private int answer = 0;

    public int getAnswer() {
        return answer;
    }

    public N_queens(int N){
        this.N = N;
        cols = new int[N];
    }

    public void back_tracking(int level){
        if(level == N){
            answer++;
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
            if(cols[i] == cols[level] || level-i == Math.abs(cols[level]-cols[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        N_queens queen = new N_queens(N);
        queen.back_tracking(0);
        System.out.println(queen.getAnswer());
    }
}