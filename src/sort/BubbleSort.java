package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args, int N) {
        Random rand = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = rand.nextInt(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
