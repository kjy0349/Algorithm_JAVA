import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int target = 0b1111111111;
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            int t = 0;
            int subBit = 0;
            do {
                t += N;
                String elem = Integer.toString(t);
                for (int i = 0; i < elem.length(); i++) {
                    int bit = elem.charAt(i) - '0';
                    subBit |= (1 << bit);
                }
            } while (target != subBit);
            sb.append("#").append(test).append(" ").append(t).append("\n");
        }
        System.out.print(sb.toString());
    }
}