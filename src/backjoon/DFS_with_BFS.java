package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_with_BFS {
    public static ArrayList<Integer> DFS(int count, Map<Integer, ArrayList<Integer>> graph, int start){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean[] visited = new boolean[count];
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(start);
        answer.add(start);
        visited[start - 1] = true;
        while (!stack.isEmpty()){
            int n = stack.pop();
            if (graph.containsKey(n)){
                ArrayList<Integer> possibles = graph.get(n);
                Collections.sort(possibles);
                for(int i = 0;i < possibles.size(); i++){
                    if (!visited[possibles.get(i) - 1]){
                        visited[possibles.get(i) - 1] = true;
                        answer.add(possibles.get(i));
                        stack.add(possibles.get(i));
                    }
                }
            } else{
                if (answer.size() != count){
                    for (int i = 0; i < count; i++){
                        if (!visited[i]){
                            visited[i] = true;
                            stack.add(i+1);
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static ArrayList<Integer> BFS(int count, Map<Integer, ArrayList<Integer>> graph, int start){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] inputs = br.readLine().split(" ");
            int count = Integer.parseInt(inputs[0]);
            for (int i = 0; i < Integer.parseInt(inputs[1]); i++){
                String[] node = br.readLine().split(" ");
                int pnode = Integer.parseInt(node[0]);
                int cnode = Integer.parseInt(node[1]);
                if (!graph.containsKey(pnode)){
                    graph.put(pnode, new ArrayList<>());
                    graph.get(pnode).add(cnode);
                } else{
                    graph.get(pnode).add(cnode);
                }
            }
            System.out.println(DFS(count, graph, Integer.parseInt(inputs[2])));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
