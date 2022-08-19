package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_1874 {
    static Stack<Integer> nums;
    static Stack<Character> ans;
    public static void bfs(Stack<Integer> stk) {
        if (nums.equals(stk)) {

        } else {
            for (int i = 0; i < nums.size(); i++) {

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        nums = new Stack<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        bfs(stk);
    }
}
