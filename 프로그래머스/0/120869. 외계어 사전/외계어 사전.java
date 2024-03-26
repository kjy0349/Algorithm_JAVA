import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Set<Character> spellSet = new HashSet<>();
        for (String elem : spell) {
            spellSet.add(elem.charAt(0));
        }
        for (int i = 0; i < dic.length; i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = 0; j < dic[i].length(); j++) {
                char elem = dic[i].charAt(j);
                if (spellSet.contains(elem) && !temp.contains(elem)) {
                    temp.add(elem);
                }
            }
            if (temp.size() == spellSet.size()) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}