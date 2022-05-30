package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_9663 {
    static int[] queens;
    static int answer = 0;
    public static void find(int N, int count) {
        if (count == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                queens[count] = i;
                boolean is_poss = true;
                for (int j = 0; j < count; j++) {
                    if (queens[j] == i || queens[j] == i + count - j || queens[j] == i - count + j) {
                        is_poss = false;
                        break;
                    }
                }
                if (is_poss) find(N, count + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queens = new int[N];
        find(N, 0);
        System.out.println(answer);
    }
}
