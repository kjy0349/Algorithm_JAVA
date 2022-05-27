package backjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_14888 {
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int[] ops;
    static int[] nums;
    static boolean[] visited;
    static ArrayList<Integer> operators = new ArrayList<>();

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
        if (count == operators.size()) {
            if (sub_sum > MAX) MAX = sub_sum;
            if (sub_sum < MIN) MIN = sub_sum;
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    perm(count + 1, N, calc(sub_sum, count, operators.get(i)));
                    visited[i] = false;
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ops[i]; j++) operators.add(i);
        }
        visited = new boolean[operators.size()];
        perm(0, N, nums[0]);
        bw.write(MAX + "\n");
        bw.write(MIN + "\n");
        bw.flush();
    }
}

