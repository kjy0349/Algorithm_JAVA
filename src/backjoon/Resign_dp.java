package backjoon;
import java.io.*;
import java.util.Arrays;

public class Resign_dp {
    static int N;
    static int[] T = new int[16];
    static int[] P = new int[16];
    static int[] d = new int[16];
    public static int solve(int i){
        if (i == N + 1) return 0;
        else if (i > N + 1) return Integer.MIN_VALUE;
        else if (d[i] != -1) return d[i];
        else {
            int c1 = solve(i + T[i]) + P[i];
            int c2 = solve(i + 1);
            d[i] = Math.max(c1, c2);
            return d[i];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] inputs;
        for (int i = 1;i <= N;i++){
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = inputs[0];
            P[i] = inputs[1];
            d[i] = -1;
        }
        System.out.println(solve(1));
    }
}