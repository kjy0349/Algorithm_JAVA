package backjoon;
import java.util.Scanner;

public class Make_one {
    static int[] d = new int[1000001];

    public static int solve(int N){
        if (N == 1) return 0;
        else if (N == 2 || N == 3) return 1;
        else if (d[N] > 0) return d[N];
        else {
            int min = 2147483647;
            if (N % 3 == 0) min = Math.min(solve(N / 3), min);
            if (N % 2 == 0) min = Math.min(solve(N / 2), min);
            min = Math.min(solve(N - 1), min);
            d[N] = min + 1;
            return d[N];
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println(solve(N));
    }
}
