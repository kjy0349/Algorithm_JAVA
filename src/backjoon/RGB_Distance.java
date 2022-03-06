package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGB_Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][3]; // 빨강 - 0, 초록 - 1, 파랑 - 2
        int[][] cost = new int[N + 1][3];
        for (int i = 1;i < N + 1;i++) cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1;i < N + 1;i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + cost[i][2];
        }
        int min_cost = Math.min(d[N][0], d[N][1]);
        min_cost = Math.min(min_cost, d[N][2]);
        System.out.println(min_cost);
    }
}
