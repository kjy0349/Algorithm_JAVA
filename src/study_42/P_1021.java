package study_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P_1021 {
    public static void rot_left(Deque<Integer> queue) {
        queue.addLast(queue.pollFirst());
    }

    public static void rot_right(Deque<Integer> queue) {
        queue.addFirst(queue.pollLast());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for (int i = 0; i < inputs.length; i++) {
            int j = 0;
            for (int elem : queue) {
                if (elem == inputs[i]) break;
                j++;
            }
            if (j <= queue.size() / 2) {
                for (int k = 0; k < j; k++) {
                    rot_left(queue);
                    result++;
                }
            } else for (int k = j; k < queue.size(); k++) {
                rot_right(queue);
                result++;
            }
            queue.pollFirst();
        }
        System.out.println(result);
    }
}
