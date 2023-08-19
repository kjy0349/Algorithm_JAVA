import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1000000;
    static int[] answer;
    static class Vertex {
        int v;
        int weight;
        Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
    static ArrayList<PriorityQueue<Vertex>> vtx;

    public static void diak(int start) {
        PriorityQueue<Vertex> pq = vtx.get(start);
        answer[start] = 0;
        while (!pq.isEmpty()) {
            Vertex vt = pq.poll();
            if (answer[vt.v] < vt.weight) continue;
            for (Vertex elem : vtx.get(vt.v)) {
                if (answer[elem.v] > vt.weight + elem.weight) {
                    answer[elem.v] = vt.weight + elem.weight;
                    pq.offer(new Vertex(elem.v, answer[elem.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        answer = new int[V + 1];
        Arrays.fill(answer, INF);
        int start = Integer.parseInt(br.readLine());
        vtx = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) vtx.add(new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight)));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            vtx.get(u).offer(new Vertex(v, w));
            if (u == start && answer[v] > w) answer[v] = w;
        }
        diak(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == INF) sb.append("INF\n");
            else sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}