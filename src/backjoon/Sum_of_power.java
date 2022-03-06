package backjoon;

import java.io.*;

public class Sum_of_power {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[100001];
        int min_value;
        d[1] = 1;
        for (int i = 2;i <= N;i++){
            min_value = Integer.MAX_VALUE;
            for (int j = 1;i - (j * j) >= 0;j++) {
                min_value = Math.min(min_value, d[i - (j * j)]);
            }
            d[i] = min_value + 1;
        }
        System.out.println(d[N]);
    }
}
