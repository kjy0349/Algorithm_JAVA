package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        for (int i = 4; i < d.length; i++) d[i] = d[i - 2] + d[i - 3];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(d[N]);
        }
    }
}
