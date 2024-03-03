import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = 0; j <= k; j++) {
                if (dp[j] >= 1 && j + coin <= k) {
                    dp[j + coin] += dp[j];
                }
            }
        }
        System.out.println(dp[k]);
    }
}