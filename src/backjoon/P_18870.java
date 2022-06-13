package backjoon;

import java.io.*;
import java.util.*;

public class P_18870 {
    static int[] nums;
    static int[] s_nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        int counter = 0;
        s_nums = nums.clone();
        Arrays.sort(s_nums);
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(s_nums[i])) {
                map.put(s_nums[i], counter);
                counter++;
            }
        }
        bw.write(Integer.toString(map.get(nums[0])));
        for (int i = 1; i < N; i++) bw.write(" " + map.get(nums[i]));
        bw.flush();
    }
}
