package backjoon;

import java.io.*;

public class Ott_plus_three_dp {
    final static int mod = 1000000009;
    public static void main(String[] args) throws IOException {
        int[] d = new int[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 4;i <= 1000000;i++){
            d[i] = (d[i - 1] + d[i - 2]) % mod;
            d[i] = (d[i] + d[i - 3]) % mod;
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0;i < T;i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(d[N] + "\n");
        }
        bw.flush();

    }
}
