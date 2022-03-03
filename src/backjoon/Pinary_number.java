package backjoon;
import java.util.Scanner;

public class Pinary_number {
    static long[][] d = new long[91][2];
    public static long solve(int N, int number){
        if (N == 1) return d[N][number];
        else if(d[N][number] > 0) return d[N][number];
        else {
            if (number == 0) d[N][0] = solve(N - 1, 0) + solve(N - 1, 1);
            else if (number == 1) d[N][1] = solve(N - 1, 0);
            return d[N][number];
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        d[1][1] = 1;
        System.out.println(solve(N, 0) + solve(N, 1));
    }
}
