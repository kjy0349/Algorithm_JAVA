package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1182 {
    static int answer = 0;

    public static void comb(int[] nums, boolean[] visited, int sub_sum, int start, int S) {
        if (sub_sum == S) {
            int z_count = 0;
            for (boolean elem : visited) {
                if (elem) {
                    z_count++;
                    break;
                }
            }
            if (z_count > 0) answer++;
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(nums, visited, sub_sum + nums[i], i + 1, S);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        boolean[] visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        comb(nums, visited, 0, 0, S);
        System.out.println(answer);
    }
}
