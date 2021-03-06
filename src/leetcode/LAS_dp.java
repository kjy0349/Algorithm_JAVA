package leetcode;

import java.util.HashMap;

public class LAS_dp {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,0,0,1,0,0,1,0,1,0,1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,1,0,0,1,0,1,1,1,1,0,1,1,0,0,0,0,1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,1,0,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,0,0,0,1,0,0,0,1,1,0,1,0,1,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,1,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,0,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1,0,1,0,1,0,0,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,0,0,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1,1,1,1};
        HashMap<Integer, Integer>[] map = new HashMap[A.length];
        int ans = 2;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                map[i].put(d, map[j].getOrDefault(d, 1) + 1);
                ans = Math.max(map[i].get(d), ans);
            }
        }
        System.out.println(ans);
    }
}
