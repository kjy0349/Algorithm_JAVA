package Programmers;

import java.util.*;
public class travel_route_recursion {
    static boolean[] visited;
    static ArrayList<String> result;

    public static String[] solution(String[][] tickets){
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);
        System.out.println(result);
        Collections.sort(result);

        return result.get(0).split(" ");
    }

    static void dfs(String now, String nodes, int count, String[][] tickets){
        if (count == tickets.length){
            result.add(nodes);
            System.out.println(result);
            return;
        }

        for(int i=0; i < tickets.length; i++){
            if (!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1], count + 1, tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}})));
    }
}
