import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] heights = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) heights[i] = Integer.parseInt(st.nextToken());
        int i = 0;
        int answer = 0;
        while (i < W) {
            boolean is_poss = false;
            int target = heights[i];
            int sub_sum = 0;
            outLoop:
            for (int j = target; j > 0; j--) {
                sub_sum = 0;
                for (int k = i + 1; k < W; k++) {
                    if (heights[k] >= j) {
                        is_poss = true;
                        i = k;
                        break outLoop;
                    } else sub_sum += j - heights[k];
                }
            }
            if (is_poss) {
                answer += sub_sum;
            } else i++;
        }
        System.out.println(answer);
    }
}