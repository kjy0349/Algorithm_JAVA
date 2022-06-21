package leetcode;

import java.util.*;
public class Merge {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                } else if (intervals[i][0] == intervals[j][0] && intervals[i][1] > intervals[j][1]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
        arr.add(intervals[0]); // arr이 [1, 2], temp가 [1, 4]
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            for (int j = 0; j < arr.size(); j++) {
                if (temp[0] <= arr.get(j)[1] && temp[1] > arr.get(j)[1]) {
                    int[] after = new int[2];
                    after[0] = arr.get(j)[0];
                    after[1] = temp[1];
                    arr.set(j, after);
                } else arr.add(temp);
            }
        }
        int[][] ret_arr = new int[arr.size()][2];
        for (int i = 0; i < ret_arr.length; i++) ret_arr[i] = arr.get(i);
        return ret_arr;
    }
}
