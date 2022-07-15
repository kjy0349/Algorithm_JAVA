package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        int start = 0;
        int end = 0;
        int S = inputs[1];
        int answer = Integer.MAX_VALUE;
        while (end < nums.length) {
            int sub_sum;
            if (start == 0) sub_sum = nums[end];
            else sub_sum = nums[end] - nums[start - 1];
            if (sub_sum < S) end++;
            else {
                if (end - start < answer) answer = end - (start - 1);
                start++;
            }
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}
