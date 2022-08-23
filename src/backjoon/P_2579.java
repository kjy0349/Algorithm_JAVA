package backjoon;
import java.util.Scanner;

public class P_2579 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) stair[i] = scan.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = stair[1];
        if (N >= 2) dp[2] = stair[2] + stair[1];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
        }
        System.out.println(dp[N]);
    }
}
