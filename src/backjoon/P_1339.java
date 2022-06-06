package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P_1339 {
    static int max = -2147483648;
    static boolean[] visited = new boolean[10];
    static Map<Character, Integer> map;
    static String[] words;
    static Character[] keys;
    public static void back_track(int alp_count, int count) {
        if (count == alp_count) {
            int result = 0;
            for (String elem : words) {
                int num = 0;
                for (int i = 0; i < elem.length(); i++) {
                    num *= 10;
                    num += map.get(elem.charAt(i));
                }
                result += num;
            }
            if (result > max) max = result;
        } else {
            for (int i = 9; i > 9 - alp_count; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    map.put(keys[count], i);
                    back_track(alp_count, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0;i < N;i++) words[i] = br.readLine();
        map = new HashMap<>();
        for (String elem : words) {
            for (int i = 0; i < elem.length(); i++) {
                if (!map.containsKey(elem.charAt(i))) map.put(elem.charAt(i), 0);
            }
        }
        int alp_count = map.size();
        keys = map.keySet().toArray(new Character[0]);
        back_track(alp_count, 0);
        System.out.println(max);
    }
}
