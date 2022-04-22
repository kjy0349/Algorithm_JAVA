package backjoon;

import java.io.*;
import java.util.*;

public class P_13549 {
    static int MAX = 200000;
    public static void bfs(int N, boolean[] map, int[] time, int[] from) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(N);
        map[N] = true;
        while (!dq.isEmpty()) {
            int current = dq.poll();
            if (current * 2 < MAX) {
                if (!map[current * 2]) {
                    dq.addFirst(current * 2);
                    time[current * 2] = time[current];
                    from[current * 2] = current;
                    map[current * 2] = true;
                }
            }
            if (current - 1 >= 0) {
                if (!map[current - 1]) {
                    dq.addLast(current - 1);
                    time[current - 1] = time[current] + 1;
                    from[current - 1] = current;
                    map[current - 1] = true;
                }
            }
            if (current + 1 < MAX) {
                if (!map[current + 1]) {
                    dq.addLast(current + 1);
                    time[current + 1] = time[current] + 1;
                    from[current + 1] = current;
                    map[current + 1] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];
        int[] time = new int[MAX];
        boolean[] map = new boolean[MAX];
        int[] from = new int[MAX];
        bfs(N, map, time, from);
        System.out.println(time[K]);
    }
}

