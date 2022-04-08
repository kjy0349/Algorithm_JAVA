package backjoon;
import java.util.*;
import java.io.*;

public class Bipartite_Graph {
    static ArrayList<Integer> first = new ArrayList<>();
    static ArrayList<Integer> second = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void bfs(boolean[] a, int start, ArrayList<ArrayList<Integer>> adjacency_list) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        a[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int elem : adjacency_list.get(x)) {
                if (!a[elem]) {
                    q.add(elem);
                    a[elem] = true;
                    second.add(elem);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0;i < K;i++){
            String[] inputs = br.readLine().split(" ");
            int V = Integer.parseInt(inputs[0]);
            int E = Integer.parseInt(inputs[1]);
            boolean[] a = new boolean[V + 1];
            ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
            for (int j = 0;j < V + 1;j++)adjacency_list.add(new ArrayList<>());
            for (int j = 0;j < E;j++) {
                inputs = br.readLine().split(" ");
                int from = Integer.parseInt(inputs[0]);
                int to = Integer.parseInt(inputs[1]);
                adjacency_list.get(from).add(to);
            }
            first.clear();
            second.clear();
            for (int j = 1;j < V + 1;j++) {
                if (!a[j]) {
                    first.add(j);
                    bfs(a, j, adjacency_list);
                }
            }
            if (first.size() > 1 && second.size() > 0) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
    }
}
