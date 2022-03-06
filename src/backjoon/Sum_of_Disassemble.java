package backjoon;
import java.io.*;

public class Sum_of_Disassemble {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int[][] d = new int[K + 1][N + 1];
        for (int i = 0;i <= N;i++) d[1][i] = 1;
        for (int i = 2;i <= K;i++){ // K
            for (int j = 0;j <= N;j++) { // N
                for (int x = 0;x <= j;x++){ // Ln
                    d[i][j] += d[i - 1][j - x];
                    d[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(d[K][N]);
    }
}
