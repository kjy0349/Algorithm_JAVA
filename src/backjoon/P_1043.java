package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int answer = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v_count = Integer.parseInt(st.nextToken());
        ArrayList<Integer> vips = new ArrayList<>();
        for (int i = 0; i < v_count; i++) vips.add(Integer.parseInt(st.nextToken()));
        ArrayList<Integer> pty = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p_count = Integer.parseInt(st.nextToken()); // 파티 참가자
            pty.clear();
            while (st.hasMoreTokens()) pty.add(Integer.parseInt(st.nextToken()));
            boolean is_poss = true;
            for (int elem : pty) {
                if (vips.contains(elem)) {
                    is_poss = false;
//                    for (int j = 0; j < visited.length; j++) {
//                        if (visited[j])
//                    }
//                    break;
                }
            }
            if (!is_poss) {
                for (int elem : pty) {
                    visited[elem] = true;
                }
            }
            else {
                for (int elem : pty) {
                    if (visited[elem]) {
                        is_poss = false;
                        break;
                    }
                }
                if (is_poss) answer++;
            }
        }
        System.out.println(answer);
    }
}
