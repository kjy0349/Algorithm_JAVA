package backjoon;
import java.util.Scanner;
public class Ost_plus {
    static int answer = 0;
    public static int make_solution(int N, int sub_sum){
        if (sub_sum == N)
            answer += 1;
        else if (sub_sum > N)
            return (0);
        else {
            make_solution(N, sub_sum + 1);
            make_solution(N, sub_sum + 2);
            make_solution(N, sub_sum + 3);
        }
        return (0);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++){
            int N = scan.nextInt();
            make_solution(N, 0);
            System.out.println(answer);
            answer = 0;
        }
    }
}