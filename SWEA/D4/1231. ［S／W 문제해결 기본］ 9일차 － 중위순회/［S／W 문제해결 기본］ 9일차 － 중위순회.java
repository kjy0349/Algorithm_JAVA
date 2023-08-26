import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void inOrder(int cur) {
        if (cur >= arr.length) return;
        inOrder(cur * 2);
        sb.append(Character.toString(arr[cur]));
        inOrder(cur * 2 + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());
            arr = new char[N + 1];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char elem = st.nextToken().charAt(0);
                arr[idx] = elem;
            }
            sb.append("#").append(test).append(" ");
            inOrder(1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}