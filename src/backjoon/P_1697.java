package backjoon;
import java.util.*;
import java.io.*;

public class P_1697 {
    static int MAX = 200000;
    public static void bfs(int N, int[] map, int[] time){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        map[N] = 1; // 처음에 방문한 N을 방문 처리를 해주지 않음.
        while (!q.isEmpty()){
            int cur = q.poll();
            if (cur + 1 < MAX)
            {
                if (map[cur + 1] == 0) {
                    q.add(cur + 1);
                    map[cur + 1] = 1;
                    time[cur + 1] = time[cur] + 1;
                }
            }
            if (cur - 1 < MAX && cur - 1 >= 0) // cur - 1이 0이 될 때 까지 돌 필요가 있음.
            {
                if (map[cur - 1] == 0) {
                    q.add(cur - 1);
                    map[cur - 1] = 1;
                    time[cur - 1] = time[cur] + 1;
                }
            }
            if (cur * 2 < MAX)
            {
                if (map[cur * 2] == 0) {
                    q.add(cur * 2);
                    map[cur * 2] = 1;
                    time[cur * 2] = time[cur] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];
        int[] map = new int[MAX];
        int[] time = new int[MAX];
        bfs(N, map, time);
        System.out.println(time[K]);
    }
}
