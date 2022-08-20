package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int elem : inputs) arr.add(elem);
        int answer = 0;
        int sub_sum = 0;
        Collections.sort(arr);
        for (int elem : arr) {
            sub_sum += elem;
            answer += sub_sum;
        }
        System.out.println(answer);
    }
}
