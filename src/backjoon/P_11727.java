package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[1] = 1;
        if (n > 1) d[2] = 3;
        for (int i = 3; i <= n; i++) d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
        System.out.println(d[n]);
    }
}
