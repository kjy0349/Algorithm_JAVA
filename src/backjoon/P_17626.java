package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            d[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0.0d) continue;
            int min = 4;
            int min_idx = 0;
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (d[i - j * j] <= min) {
                    min = d[i - j * j];
                    min_idx = j * j;
                }
            }
            d[i] = d[i - min_idx] + 1;
        }
        System.out.println(d[n]);
    }
}
