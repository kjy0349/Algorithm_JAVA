package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_1541 {
    static int answer = Integer.MAX_VALUE;
    static Stack<Character> stack = new Stack<>();
    public static int calc(int op1, int op2, char oper) {
        int ret_num = 0;
        switch (oper) {
            case '+':
                ret_num = op1 + op2;
                break;
            case '-':
                ret_num = op1 - op2;
                break;
        }
        return ret_num;
    }

    public static void solution(String str, int start, Queue<Integer> opers) {
        char[] exp = str.toCharArray();
        int num = 0;
        for (int i = start; i < exp.length; i++) {
            if ((exp[i] >= '0' && exp[i] <= '9')) {
                num *= 10;
                num += exp[i] - '0';
                if (i == exp.length - 1) opers.add(num);
            } else {
                opers.add(num);
                if (stack.isEmpty()) {
                    stack.add(exp[i]);
                } else {
                    int op1 = opers.poll();
                    int op2 = opers.poll();
                    opers.add(calc(op1, op2, exp[i]));
                    solution(str, i + 1, opers);
                    opers.poll();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    }
}
