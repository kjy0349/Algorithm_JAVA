package leetcode;

import java.util.*;
public class SumOfTwoNumbers {
    ArrayList<Integer> findSum(int a[], int b[]) {
        int num;
        int remain = 0;
        int size = Math.max(a.length, b.length);
        int[] new_arr1 = new int[size];
        int[] new_arr2 = new int[size];
        Arrays.fill(new_arr1, 0);
        if (size == a.length) {
            System.arraycopy(b, 0, new_arr1, size - b.length, b.length);
            new_arr2 = a.clone();
        } else {
            System.arraycopy(a, 0, new_arr1, size - a.length, a.length);
            new_arr2 = b.clone();
        }
        ArrayList<Integer> ret_arr = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            if (remain == 1) {
                num = new_arr1[i] + new_arr2[i] + remain;
                remain = 0;
            } else num = new_arr1[i] + new_arr2[i];
            if (num >= 10) {
                remain = 1;
                num -= 10;
            }
            ret_arr.add(num);
        }
        if (remain == 1) ret_arr.add(1);
        Collections.reverse(ret_arr);
        return ret_arr;
    }
}
