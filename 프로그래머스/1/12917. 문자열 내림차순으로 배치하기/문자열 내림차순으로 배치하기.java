import java.util.*;
import java.util.stream.Collectors;
class Solution {
public String solution(String s) {
            return s.chars()
                    .mapToObj(c -> (char) c)
                    .sorted(new Comparator<Character>() {
                        @Override
                        public int compare(Character o1, Character o2) {
                            return Character.compare(o2, o1);
                        }
                    })
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
}