package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_15658 {
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int[] ops;
    static int[] nums;

    public static int calc(int sub_sum, int count, int operator) {
        // 0 : + , 1 : -, 2 : *, 3 : /
        int result = 0;
        switch (operator) {
            case 0:
                result = sub_sum + nums[count + 1];
                break;
            case 1:
                result = sub_sum - nums[count + 1];
                break;
            case 2:
                result = sub_sum * nums[count + 1];
                break;
            case 3:
                result = sub_sum / nums[count + 1];
        }
        return result;
    }

    public static void perm(int count, int N, int sub_sum) {
        if (count == N - 1) {
            if (sub_sum > MAX) MAX = sub_sum;
            if (sub_sum < MIN) MIN = sub_sum;
        } else {
            for (int i = 0; i < 4; i++) {
                if (ops[i] > 0) {
                    ops[i]--;
                    perm(count + 1, N, calc(sub_sum, count, i));
                    ops[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) ops[i] = Integer.parseInt(st.nextToken());
        perm(0, N, nums[0]);
        bw.write(MAX + "\n");
        bw.write(MIN + "\n");
        bw.flush();
    }
}

