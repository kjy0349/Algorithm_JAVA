package Programmers;
import java.util.*;
public class Make_Chatting {
    class Solution {
        public ArrayList<String> solution(String[] record) {
            HashMap<String, String> names = new HashMap<>();
            ArrayList<String> answer = new ArrayList<>();
            for (String elem : record) {
                StringTokenizer st = new StringTokenizer(elem);
                String command = st.nextToken();
                if (command.equals("Change") || command.equals("Enter")) names.put(st.nextToken(), st.nextToken());
            }
            for (String elem : record) {
                StringBuilder sb = new StringBuilder();
                StringTokenizer st = new StringTokenizer(elem);
                String command = st.nextToken();
                if (command.equals("Enter")) {
                    sb.append(names.get(st.nextToken())).append("님이 들어왔습니다.");
                    answer.add(sb.toString());
                }
                else if(command.equals("Leave")) {
                    sb.append(names.get(st.nextToken())).append("님이 나갔습니다.");
                    answer.add(sb.toString());
                }
            }
            return answer;
        }
    }
}
