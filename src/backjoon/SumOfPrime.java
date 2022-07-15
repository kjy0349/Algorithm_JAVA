package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        boolean[] primes = new boolean[N + 1];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!primes[i]) {
                if (i == 2) arr.add(2);
                else arr.add(arr.get(arr.size() - 1) + i);
                for (int j = i; j <= N; j += i) primes[j] = true;
            }
        }
        int start = 0;
        int end = 0;
        int answer = 0;
        while (end < arr.size()) {
            int sub_sum;
            if (start == 0) sub_sum = arr.get(end);
            else sub_sum = arr.get(end) - arr.get(start - 1);
            if (sub_sum < N) end++;
            else {
                if (sub_sum == N) answer++;
                start++;
            }
        }
        System.out.println(answer);
    }
}
