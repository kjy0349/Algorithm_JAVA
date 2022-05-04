package Programmers;

public class Skill_tree {
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for (String elem : skill_trees) {
                int poss_index = -1;
                boolean possible = true;
                for (int i = 0;i < elem.length();i++) {
                    int index = skill.indexOf(elem.charAt(i));
                    if (poss_index == -1 && index == 0) poss_index++;
                    if (index != -1 && index > poss_index) {
                        possible = false;
                        break;
                    } else if (index != -1) poss_index++;
                }
                if (possible) answer++;
            }
            return answer;
        }
    }
}
