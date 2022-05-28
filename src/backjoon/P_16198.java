package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_16198 {
    static int answer = -1;
    public static void back(int[] marble, boolean[] visited, int sub_sum, int count)
    {
        if (count == 2) {
            if (answer < sub_sum) answer = sub_sum;
        }
        else
        {
            for (int i = 1; i < marble.length - 1; i++) {
                if (!visited[i])
                {
                    visited[i] = true;
                    int b_ind = i - 1;
                    int f_ind = i + 1;
                    while (visited[b_ind] || visited[f_ind])
                    {
                        if (visited[b_ind]) b_ind--;
                        if (visited[f_ind]) f_ind++;
                    }
                    back(marble, visited, sub_sum + (marble[b_ind] * marble[f_ind]), count - 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] marble = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0;i < N;i++) marble[i] = Integer.parseInt(st.nextToken());
        back(marble, visited, 0, N);
        System.out.println(answer);
    }
}
