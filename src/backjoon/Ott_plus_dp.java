package backjoon;
import java.util.Scanner;
import java.io.*;

public class Ott_plus_dp {
    static int[] d = new int[12];
    public static int solve(int N){
        if (N == 1) return 1;
        else if (N == 2) return 2;
        else if (N == 3) return 4;
        else if (d[N] > 0) return d[N];
        else {
            d[N] = solve(N - 1) + solve(N - 2) + solve(N - 3);
            return d[N];
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int N;
        for (int i = 0;i < T;i++){
            N = scan.nextInt();
            System.out.println(solve(N));
        }
    }
}
