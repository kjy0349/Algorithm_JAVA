package backjoon;
import java.io.*;
import java.util.*;
public class Resign {
    static int answer = -1;
    static int[] T;
    static int[] P;
    static void solve(int N, int day, int sub_sum){
        if (day == N){
            if (sub_sum > answer) answer = sub_sum;
        } else if(day < N){
            for (int i = day;i < T.length;i++){
                solve(N, i + T[i], sub_sum + P[i]);
                solve(N, i + 1, sub_sum);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().split(" ")[0]);
        T = new int[N];
        P = new int[N];
        int[] inputs;
        for (int i = 0;i < N;i++){
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = inputs[0];
            P[i] = inputs[1];
        }
        solve(N, 0, 0);
        System.out.println(answer);
    }
}
