package sort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {
    public static void main(String[] args, int N) {
        Random rand = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = rand.nextInt(N);
        int[] count = new int[N];
        for (int i = 0; i < N; i++) count[arr[i]]++;
        for (int i = 1; i < N; i++) count[i] += count[i - 1];
        int[] ret_arr = new int[N];
        for (int i = arr.length - 1; i >= 0; i--) {
            ret_arr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
    }
}
