package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2003 {
    static int[] A;
    static int answer = 0;
    static int M;
    public static void bfs(int start, int sub_sum) {
        for (int i = start; i < A.length; i++) {
            if (sub_sum + A[i] == M) answer++;
            else bfs(i + 1, sub_sum + A[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        M  = inputs[1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        bfs(0, 0);
        System.out.println(answer);
    }
}
