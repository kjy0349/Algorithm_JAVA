package Programmers;

import java.util.*;
import java.lang.*;
public class travel_route {
    public static class Airport implements Comparable<Airport> {
        String start;
        String arrive;
        int index;

        Airport(String current, String next, int index) {
            this.start = current;
            this.arrive = next;
            this.index = index;
        }

        @Override
        public int compareTo(Airport airport) {
            if (this.arrive.compareTo(airport.arrive) < 0) {
                return -1;
            } else if (this.arrive.compareTo(airport.arrive) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class Solution {
        public static ArrayList<String> solution(String[][] tickets) {
            ArrayList<String> answer = new ArrayList<>();
            boolean[] visited = new boolean[tickets.length];

            Queue<Airport> queue = new LinkedList<>();
            String begin = "ICN";
            ArrayList<Airport> start_possibles = new ArrayList<>();
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(begin)) {
                    start_possibles.add(new Airport(tickets[i][0], tickets[i][1], i));
                }
            }
            Collections.sort(start_possibles);
            queue.add(start_possibles.get(0));
            answer.add(start_possibles.get(0).start);
            answer.add(start_possibles.get(0).arrive);
            visited[start_possibles.get(0).index] = true;
            while (!queue.isEmpty()) {
                Airport airport = queue.poll();
                ArrayList<Airport> possibles = new ArrayList<>();
                for (int i = 0; i < tickets.length; i++) {
                    if (airport.arrive.equals(tickets[i][0])) {
                        possibles.add(new Airport(tickets[i][0], tickets[i][1], i));
                    }
                }
                Collections.sort(possibles);
                for (Airport possible : possibles) {
                    if (!visited[possible.index]) {
                        visited[possible.index] = true;
                        queue.add(possible);
                        answer.add(possible.arrive);
                        break;
                    }
                }
                if (queue.isEmpty() && answer.size() < tickets.length + 2){
                    for (int i = 0; i < visited.length; i++){
                        if (!visited[i]){
                            queue.add(new Airport(tickets[i][0], tickets[i][1], i));
                            visited[i] = true;
                            answer.add(tickets[i][1]);
                            break;
                        }
                    }
                    continue;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}));
    }
}
