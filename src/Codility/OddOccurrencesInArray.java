package Codility;
import java.util.*;
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int elem : A) {
            if (!map.containsKey(elem)) map.put(elem, 1);
            else map.put(elem, map.get(elem) + 1);
        }
        Set<Integer> keyset = map.keySet();
        for (int elem : keyset) {
            if (map.get(elem) % 2 == 1) {
                answer = elem;
                break;
            }
        }
        return answer;
    }
}
