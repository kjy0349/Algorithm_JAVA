package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class P_1062 {
    static ArrayList<String> matched;
    static boolean[] visited;
    static ArrayList<Character> letters;
    static int answer = 0;

    public static void get_ans(int count, int K, int start) {
        if (count == K || 5 + count == visited.length) {
            int pos_count = 0;
            for (String elem : matched) {
                boolean is_poss = true;
                for (int i = 0; i < elem.length(); i++) {
                    for (int j = 0; j < letters.size(); j++) {
                        if (elem.charAt(i) == letters.get(j) && !visited[j]) {
                            is_poss = false;
                            break;
                        }
                    }
                    if (!is_poss) break;
                }
                if (is_poss) pos_count++;
            }
            if (answer < pos_count) answer = pos_count;
        } else {
            for (int i = start; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    get_ans(count + 1, K, i + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String pattern = "anta([a-z]*)tica";
        Pattern poss = Pattern.compile(pattern);
        int N = inputs[0];
        int K = inputs[1];
        String[] words = new String[N];
        for (int i = 0; i < N; i++) words[i] = br.readLine();
        if (K >= 5) {
            matched = new ArrayList<>();
            K -= 5;
            letters = new ArrayList<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
            for (int i = 0; i < N; i++) {
                Matcher matcher = poss.matcher(words[i]);
                if (matcher.matches()) {
                    String substr = matcher.group(1);
                    matched.add(substr);
                    for (int j = 0; j < substr.length(); j++) {
                        char alp = substr.charAt(j);
                        if (!letters.contains(alp)) letters.add(alp);
                    }
                }
            }
            visited = new boolean[letters.size()];
            Arrays.fill(visited, 0, 5, true);
            get_ans(0, K, 5);
        }
        System.out.println(answer);
    }
}
