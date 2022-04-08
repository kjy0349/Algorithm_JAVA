package backjoon;
import java.util.*;
import java.io.*;

public class DFS_BFS {
    public static void dfs(boolean[] a, Stack<Integer> dfs, ArrayList<ArrayList<Integer>> adjacency_list, int start, int V){
        if (start == V)
        {
            a[start] = true;
            dfs.add(start);
            System.out.print(start);
        }
        while (!dfs.empty()) {
            ArrayList<Integer> elem = adjacency_list.get(dfs.pop());
            for (Integer vertex : elem) {
                if (!a[vertex]) {
                    a[vertex] = true;
                    dfs.add(vertex);
                    System.out.print(" " + vertex);
                    dfs(a, dfs, adjacency_list, vertex, V);
                }
            }
        }
    }

    public static void bfs(boolean[] a, ArrayList<ArrayList<Integer>> adjacency_list, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        a[start] = true;
        System.out.print(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int vertex : adjacency_list.get(x)) {
                if (!a[vertex]) {
                    a[vertex] = true;
                    q.add(vertex);
                    System.out.print(" " + vertex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int V = inputs[2];
        boolean[] a = new boolean[N + 1];
        Stack<Integer> dfs = new Stack<>();
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0;i < N + 1;i++) adjacency_list.add(new ArrayList<>());
        for (int i = 0;i < M;i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = inputs[0];
            int to = inputs[1];
            adjacency_list.get(from).add(to);
            adjacency_list.get(to).add(from);
        }
        for (ArrayList<Integer> elem : adjacency_list) Collections.sort(elem);
        dfs(a, dfs, adjacency_list, V, V);
        System.out.println();
        a = new boolean[N + 1];
        bfs(a, adjacency_list, V);
    }
}
