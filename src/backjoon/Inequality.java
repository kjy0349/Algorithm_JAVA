package backjoon;
import java.util.Scanner;
public class Inequality {
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static String max_string = "";
    static String min_string = "";
    static boolean check_sign(int a, int b, char sign){
        boolean is_correct = false;
        if (sign == '<'){
            if (a < b) is_correct = true;
        }
        else if (sign == '>'){
            if (a > b) is_correct = true;
        }
        return (is_correct);
    }
    static void solve(int count, StringBuilder answer, boolean[] visited, char[] signs){
        if (count == signs.length + 1){
            String sub_ans = answer.toString();
            long sub_sum = Long.parseLong(sub_ans);
            if (sub_sum > max){
                max = sub_sum;
                max_string = sub_ans;
            }
            if (sub_sum < min){
                min = sub_sum;
                min_string = sub_ans;
            }
        } else{
                for (int i = 0; i < 10; i++) {
                    if (count == 0 || (!visited[i] && check_sign(answer.charAt(answer.length() - 1) - '0', i, signs[count - 1]))) {
                        visited[i] = true;
                        answer.append(i);
                        solve(count + 1, answer, visited, signs);
                        answer.deleteCharAt(answer.length() - 1);
                        visited[i] = false;
                    }
                }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        char[] signs = new char[N];
        boolean[] visited = new boolean[10];
        for (int i = 0;i < N;i++) signs[i] = scan.next().toCharArray()[0];
        StringBuilder sb = new StringBuilder();
        solve(0, sb, visited, signs);
        System.out.println(max_string);
        System.out.println(min_string);
    }
}
