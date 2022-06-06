package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2529 {
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static String max_string;
    static String min_string;
    static boolean[] visited = new boolean[10];

    public static boolean valid(int op1, int op2, String inq) {
        if (inq.equals("<")) return op1 < op2;
        if (inq.equals(">")) return op1 > op2;
        else {
            System.out.println("error!");
            return false;
        }
    }

    public static void back_track(int k, String[] inq, StringBuilder sb, int count) {
        if (count == k) {
            String string = sb.toString();
            long value = Long.parseLong(string);
            if (value < min) {
                min = value;
                min_string = string;
            }
            if (value > max) {
                max = value;
                max_string = string;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (!visited[i] && valid(sb.charAt(count) - '0', i, inq[count])) {
                    visited[i] = true;
                    sb.append(i);
                    back_track(k, inq, sb, count + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] inq = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) inq[i] = st.nextToken();
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(i));
            visited[i] = true;
            back_track(k, inq, sb, 0);
            visited[i] = false;
        }
        System.out.println(max_string);
        System.out.println(min_string);
    }
}
