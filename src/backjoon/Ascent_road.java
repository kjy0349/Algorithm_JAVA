package backjoon;
import java.io.*;

public class Ascent_road {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][10];
        for (int i = 0;i < 10;i++) d[1][i] = 1;
        for (int i = 1;i < N + 1;i++){
            for (int k = 0;k < 10;k++){
                for (int j = 0;j <= k;j++){
                    d[i][k] = (d[i][k] + d[i - 1][j]) % 10007;
                }
            }
        }
        int sum = 0;
        for (int elem : d[N]) sum = (sum + elem) % 10007;
        System.out.println(sum);
    }
}
