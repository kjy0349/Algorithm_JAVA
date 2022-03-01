package backjoon;
import java.util.Scanner;

public class Two_multiple_n_Tiling_2 {
    static int d[] = new int[1001];
    public static int solve(int N){
        if (N == 1) return (1);
        else if (N == 2) return (3);
        else if (d[N] > 0) return d[N];
        else {
            d[N] = (solve(N - 1) + solve(N - 2) * 2) % 10007;
            return d[N];
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println(solve(N));
    }
}
