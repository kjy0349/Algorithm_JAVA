package backjoon;
import java.io.*;
import java.util.*;

public class P_13913 {
    static int MAX = 200000;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void bfs(int N, boolean[] map, int[] time, int[] from) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        map[N] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current + 1 < MAX) {
                if (!map[current + 1]) {
                    q.add(current + 1);
                    time[current + 1] = time[current] + 1;
                    from[current + 1] = current;
                    map[current + 1] = true;
                }
            }
            if (current - 1 >= 0) {
                if (!map[current - 1]) {
                    q.add(current - 1);
                    time[current - 1] = time[current] + 1;
                    from[current - 1] = current;
                    map[current - 1] = true;
                }
            }
            if (current * 2 < MAX) {
                if (!map[current * 2]) {
                    q.add(current * 2);
                    time[current * 2] = time[current] + 1;
                    from[current * 2] = current;
                    map[current * 2] = true;
                }
            }
        }
    }

    public static void print(int[] from, int N, int K) throws IOException{
        if (from[K] != N) print(from, N, from[K]);
        bw.write(from[K] + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];
        int[] time = new int[MAX];
        int[] from = new int[MAX];
        boolean[] map = new boolean[MAX];
        bfs(N, map, time, from);
        bw.write(time[K] + "\n");
        if (N == K) {
            bw.write(Integer.toString(K));
        } else {
            print(from, N, K);
            bw.write(Integer.toString(K));
        }
        bw.flush();
    }
}
