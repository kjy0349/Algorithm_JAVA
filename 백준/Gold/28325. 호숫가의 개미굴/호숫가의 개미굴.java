import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] nums = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) nums[i] = Long.parseLong(st.nextToken());
            int cnt = 0;
            for (int i = 0; i < N; i++) if(nums[i] == 0) cnt++;
            if (cnt == N) {
                System.out.println(nums.length / 2);
                return;
            }
            int maxIdx = 0;
            for (int i = 1; i < N; i++) if (nums[maxIdx] < nums[i]) maxIdx = i;
            long[] temp = new long[N];
            int idx = 0;
            for (int i = maxIdx; i < N; i++) temp[idx++] = nums[i];
            for (int i = 0; i < maxIdx; i++) temp[idx++] = nums[i];
            int answer = 0;
            long[] dp = new long[N];
            answer += Arrays.stream(temp).sum();
            for (int i = 0, j; i < N; i++) {
                if (nums[i] > 0 || dp[i] > 0) continue;
                for (j = i; j < N && nums[j] == 0; j++) dp[j] = 1;
                answer += (j - i + 1) / 2;
            }
            System.out.println(answer);
        }
}