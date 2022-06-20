package leetcode;

public class Lcis {
    static int[] arr;
    static int answer;
    public static void bfs(int count, int start, int prev) {
        if (start == arr.length) {
            if (count > answer) answer = count;
        } else {
            if (arr[start] > prev) bfs(count + 1, start + 1, arr[start]);
            else {
                if (count > answer) answer = count;
            }
        }

    }
    public int findLengthOfLCIS(int[] nums) {
        arr = nums.clone();
        answer = 0;
        for (int i = 0; i < arr.length; i++) {
            bfs(0, i, -2147483648);
        }
        return answer;
    }
}
