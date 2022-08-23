package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_2606 {
    static ArrayList<ArrayList<Integer>> edge;
    static boolean[] vert;
    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        queue.add(1);
        vert[1] = true;
        while (!queue.isEmpty()) {
            int target = queue.poll();
            for (int elem : edge.get(target)) {
                if (!vert[elem]) {
                    queue.add(elem);
                    vert[elem] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        vert = new boolean[N + 1];
        edge = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) edge.add(new ArrayList<>());
        int E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edge.get(inputs[0]).add(inputs[1]);
            edge.get(inputs[1]).add(inputs[0]);
        }
        System.out.println(bfs());
    }
}
