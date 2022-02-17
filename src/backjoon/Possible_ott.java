package backjoon;
import java.util.Scanner;
public class Possible_ott {
    static int answer;
    static StringBuilder sb = new StringBuilder();
    static void solve(int N, int sub_sum){
        if (sub_sum == N) answer++;
        else if (sub_sum < N){
            solve(N, sub_sum + 1);
            solve(N, sub_sum + 2);
            solve(N, sub_sum + 3);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int N;
        for (int i = 0;i < T;i++){
            answer = 0;
            N = scan.nextInt();
            solve(N, 0);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
