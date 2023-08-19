import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Vtx implements Comparable<Vtx> {
        int v;
        int w;
        Vtx (int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Vtx o) {
            return Long.compare(this.w, o.w);
        }
    }
    static int X;
    static long answer;
    static long[][] d;
    static long INF = Long.MAX_VALUE;
    static ArrayList<ArrayList<Vtx>> vtx;
    public static void diak(int start) {
        PriorityQueue<Vtx> pq = new PriorityQueue<>();
        for (Vtx elem : vtx.get(start)) pq.offer(elem);
        d[start][start] = 0;
        while (!pq.isEmpty()) {
            Vtx vt = pq.poll(); // 최소 weight를 가진 간선
            if (vt.w > d[start][vt.v]) continue;
            for (Vtx elem : vtx.get(vt.v)) {
                int dis = vt.w + elem.w;
                if (dis < d[start][elem.v]) {
                    d[start][elem.v] = dis;
                    pq.offer(new Vtx(elem.v, dis));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        d = new long[N + 1][N + 1];
        vtx = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) Arrays.fill(d[i], INF);
        for (int i = 0; i < N + 1; i++) vtx.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            vtx.get(u).add(new Vtx(v, w));
            d[u][v] = w;
        }
        for (int i = 1; i <= N; i++) {
            diak(i);
        }
        for (int i = 1; i <= N; i++) {
            if (d[i][X] != Long.MAX_VALUE && d[X][i] != Long.MAX_VALUE) {
                long elem = d[i][X] + d[X][i];
                if (elem > answer) answer = elem;
            }
        }
        System.out.println(answer);
    }
}