package backjoon;
import java.io.*;
import java.util.Arrays;

public class Essence_triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int     N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][N + 1];
        int[][] d = new int[N + 1][N + 1];
        int     max_num = 0;
        for (int i = 1;i < N + 1;i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(temp, 0, A[i], 1, i);
        }
        d[1][1] = A[1][1];
        for (int i = 2;i < N + 1;i++){
            for (int j = 1;j < N + 1; j++){
                d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + A[i][j];
            }
        }
        for (int j = 1;j < N + 1;j++) {
            if (d[N][j] > max_num) max_num = d[N][j];
        }
        System.out.println(max_num);
    }
}
