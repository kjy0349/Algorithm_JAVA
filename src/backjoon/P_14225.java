package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_14225 {
    static boolean[] answers = new boolean[20000001];
    public static void comb(int[] nums, boolean[] visited, int start, int sub_sum) {
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                answers[sub_sum + nums[i]] = true;
                visited[i] = true;
                comb(nums, visited, i + 1, sub_sum + nums[i]);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[N];
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        comb(nums, visited, 0, 0);
        for (int i = 1; i < answers.length; i++) {
            if (!answers[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
