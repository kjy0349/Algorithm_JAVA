package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    static int[] A;
    static int[] B;
    static long[] adp;
    static long[] bdp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
        adp = new long[N + 1];
        bdp = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            adp[i] = adp[i - 1] + A[i - 1];
            bdp[i] = bdp[i - 1] + B[i - 1];
        }
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (adp[j] - adp[i] == bdp[j] - bdp[i]) answer++;
            }
        }
        System.out.println(answer);
    }
}
