package backjoon;

import java.io.*;
import java.util.*;

public class P_1260 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> graph;
    public static void bfs(int V, int N) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(V);
        visited[V] = true;
        bw.write(Integer.toString(V));
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ArrayList<Integer> edges = graph.get(v);
            Collections.sort(edges);
            for (int elem : edges) {
                if (!visited[elem]) {
                    visited[elem] = true;
                    queue.add(elem);
                    bw.write(" " + elem);
                }
            }
        }
        bw.newLine();
    }

    public static void dfs(int V, int N) throws IOException {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];
        stack.add(V);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                if (visited[v]) bw.write(v + " ");
                ArrayList<Integer> edges = graph.get(v);
                edges.sort(Collections.reverseOrder());
                for (int elem : edges) {
                    if (!visited[elem]) {
                        stack.add(elem);
                    }
                }
            }
        }
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new ArrayList<>();
        int N = inputs[0];
        int M = inputs[1];
        int V = inputs[2];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int[] cord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(cord[0]).add(cord[1]);
            graph.get(cord[1]).add(cord[0]);
        }
        dfs(V, N);
        bfs(V, N);
        bw.flush();
    }
}
