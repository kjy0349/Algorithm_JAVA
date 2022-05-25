package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_6603 {
    static StringBuilder sb = new StringBuilder();
    public static void comb(int[] nums, boolean[] visited, int start, int count) {
        if (count == 6) {
            boolean is_first = true;
            for (int i = 0;i < visited.length;i++) {
                if (visited[i]) {
                    if (is_first) {
                        sb.append(nums[i]);
                        is_first = false;
                    } else sb.append(" ").append(nums[i]);
                }
            }
            sb.append("\n");
        } else {
            for (int i = start; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    comb(nums, visited, i + 1, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0)
                break;
            int[] nums = new int[K];
            boolean[] visited = new boolean[K];
            for (int i = 0; i < K; i++) nums[i] = Integer.parseInt(st.nextToken());
            comb(nums, visited, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
