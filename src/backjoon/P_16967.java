package backjoon;
import java.io.*;
import java.util.*;

public class P_16967 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = inputs[0];
        int W = inputs[1];
        int X = inputs[2];
        int Y = inputs[3];
        int[][] B  = new int[H + X][W + Y];
        int[][] A = new int[H][W];
        for (int i = 0; i < H + X; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0;j < W + Y;j++) B[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (j < Y || i < X) A[i][j] = B[i][j];
                else A[i][j] = B[i][j] - A[i - X][j - Y];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] elem : A) {
            sb.append(elem[0]);
            for (int j = 1; j < elem.length; j++) sb.append(" ").append(elem[j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
