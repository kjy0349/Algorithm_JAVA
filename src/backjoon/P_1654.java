package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = inputs[0];
        int N = inputs[1];
        long answer = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < K; i++) arr.add(Integer.parseInt(br.readLine()));
        long low = 0, high = (long)Integer.MAX_VALUE + 1;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long sub_sum = 0;
            for (int elem : arr) sub_sum += elem / mid;
            if (sub_sum >= N && answer < mid) {
                answer = mid;
                low = mid;
            } else high = mid;
        }
        System.out.println(answer);
    }
}
