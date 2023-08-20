import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Vtx implements Comparable<Vtx> {
        int vtx;
        int weight;
        Vtx(int vtx, int weight) {
            this.vtx = vtx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Vtx v) {
            return Integer.compare(this.weight, v.weight);
        }
    }

    static ArrayList<ArrayList<Vtx>> vertices;
    static int[][] d;

    public static boolean bellmanFord(int start) {
        d[start][start] = 0;
        boolean update = false;
        for (int i = 0; i < vertices.size() - 2; i++) { // 정점의 개수 - 1개만큼 작업
            update = false;

            for (int j = 1; j < vertices.size(); j++) {
                for (Vtx elem : vertices.get(j)) {
                    if (d[start][j] != Integer.MAX_VALUE
                            && d[start][elem.vtx] > d[start][j] + elem.weight) {
                        d[start][elem.vtx] = d[start][j] + elem.weight;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        if (update) {
            for (int i = 1; i < vertices.size(); i++) {
                for (Vtx elem : vertices.get(i)) {
                    if (d[start][i] != Integer.MAX_VALUE
                    && d[start][elem.vtx] > d[start][i] + elem.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        vertices = new ArrayList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        d = new int[501][501];
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            vertices.clear();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N + 1; i++) vertices.add(new ArrayList<>());
            for (int i = 1; i < N + 1; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                vertices.get(s).add(new Vtx(e, t));
                vertices.get(e).add(new Vtx(s, t));
                if (d[s][e] > t) d[s][e] = t;
                if (d[e][s] > t) d[e][s] = t;
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                vertices.get(s).add(new Vtx(e, -t));
                if (d[s][e] > -t) d[s][e] = -t;
            }
            boolean is_poss = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    is_poss = true;
                    break;
                }
            }
            if (!is_poss) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.print(sb);
    }
}