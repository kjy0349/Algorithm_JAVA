import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Vtx {
        int vtx;
        int weight;
        Vtx(int vtx, int weight) {
            this.vtx = vtx;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Vtx>> edges;
    static int[][] d;
    static int answer;

    public static void diak(int start) {
        PriorityQueue<Vtx> pq = new PriorityQueue<>(new Comparator<Vtx>() {
            @Override
            public int compare(Vtx o1, Vtx o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        for (Vtx elem : edges.get(start)) pq.offer(elem);
        d[start][start] = 0;
        while (!pq.isEmpty()) {
            Vtx vt = pq.poll();
            if (d[start][vt.vtx] < vt.weight) continue;
            for (Vtx elem : edges.get(vt.vtx)) {
                if (vt.weight != Integer.MAX_VALUE && elem.weight != Integer.MAX_VALUE) {
                    int dist = vt.weight + elem.weight;
                    if (d[start][elem.vtx] > dist) {
                        d[start][elem.vtx] = dist;
                        pq.offer(new Vtx(elem.vtx, dist));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        d = new int[N + 1][N + 1];
        answer = -1;
        edges = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) edges.add(new ArrayList<>());
        for (int i = 1; i < N + 1; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(s).add(new Vtx(e, w));
            edges.get(e).add(new Vtx(s, w));
            if (d[s][e] > w) d[s][e] = w;
            if (d[e][s] > w) d[e][s] = w;
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        diak(1);
        diak(u);
        diak(v);
        if (d[1][u] != Integer.MAX_VALUE && d[u][v] != Integer.MAX_VALUE
        && d[v][N] != Integer.MAX_VALUE) {
            answer = d[1][u] + d[u][v] + d[v][N];
        }
        if (d[1][v] != Integer.MAX_VALUE && d[v][u] != Integer.MAX_VALUE
                && d[u][N] != Integer.MAX_VALUE) {
            int compare = d[1][v] + d[v][u] + d[u][N];
            if (compare < answer) answer = compare;
        }
        System.out.println(answer);
    }
}