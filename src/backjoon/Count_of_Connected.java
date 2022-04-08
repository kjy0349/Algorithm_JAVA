package backjoon;
import java.io.*;
import java.util.*;

public class Count_of_Connected {
    public static void dfs(boolean a[], ArrayList<ArrayList<Integer>> adjacency_list, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        a[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int elem : adjacency_list.get(x)) {
                if (!a[elem]) {
                    q.add(elem);
                    a[elem] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        for (int i = 0;i < N + 1;i++) adjacency_list.add(new ArrayList<>());
        boolean a[] = new boolean[N + 1];
        for (int i = 0;i < M;i++) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            adjacency_list.get(from).add(to);
            adjacency_list.get(to).add(from);
        }
        int count = 0;
        for (int i = 1;i < adjacency_list.size();i++) {
            if (!a[i]) {
                dfs(a, adjacency_list, i);
                count++;
            }
        }
        System.out.println(count);
    }
}
