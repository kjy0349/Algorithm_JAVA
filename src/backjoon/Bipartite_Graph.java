package backjoon;
import java.util.*;
import java.io.*;

public class Bipartite_Graph {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean solve(ArrayList<ArrayList<Integer>> adjacency_list, int[] color, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (color[x] == 0) color[x] = 1;
            for (int elem : adjacency_list.get(x)) {
                if (color[elem] == 0) {
                    q.add(elem);
                    color[elem] = 3 - color[x];
                }
                else if (color[x] == color[elem]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0;i < K;i++) {
            String[] inputs = br.readLine().split(" ");
            int V = Integer.parseInt(inputs[0]);
            int E = Integer.parseInt(inputs[1]);
            boolean is_possible = true;
            ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
            for (int j = 0;j < V + 1;j++)adjacency_list.add(new ArrayList<>());
            for (int j = 0;j < E;j++) {
                inputs = br.readLine().split(" ");
                int from = Integer.parseInt(inputs[0]);
                int to = Integer.parseInt(inputs[1]);
                adjacency_list.get(from).add(to);
                adjacency_list.get(to).add(from);
            }
            int[] color = new int[V + 1];
            for (int j = 1;j < V + 1;j++) {
                if (color[j] == 0) {
                    if (!solve(adjacency_list, color, j)) {
                        is_possible = false;
                        break;
                    }
                }
            }
            if (is_possible) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
    }
}
