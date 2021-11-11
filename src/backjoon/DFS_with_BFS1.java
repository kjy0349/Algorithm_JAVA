package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_with_BFS1 {
    static boolean[] visited;
    static ArrayList<String> result;

    static void dfs(String now, String nodes, int count, String[][] graph){
        if (count == visited.length){
            result.add(nodes);
            return;
        }
        for(int i=0; i < graph.length; i++){
            if (!visited[i] && graph[i][0].equals(now)){
                visited[i] = true;
                dfs(graph[i][1], nodes + " " + graph[i][1], count + 1, graph);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] inputs = br.readLine().split(" ");
            String[][] nodes = new String[Integer.parseInt(inputs[1])][2];
            visited = new boolean[Integer.parseInt(inputs[0])];
            for (int i = 0; i < Integer.parseInt(inputs[1]); i++){
                String[] node = br.readLine().split(" ");
                nodes[i] = node;
            }
            dfs(inputs[2], inputs[2], 0 , nodes);
            System.out.println(Arrays.toString(result.get(0).split(" ")));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
