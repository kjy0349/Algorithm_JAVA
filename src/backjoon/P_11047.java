package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class P_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];
        int answer = 0;
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) set.add(Integer.parseInt(br.readLine()));
        for (int elem : set) {
            if (elem <= K && K != 0) {
                int mok = K / elem;
                answer += mok;
                K -= mok * elem;
            }
        }
        System.out.println(answer);
    }
}
