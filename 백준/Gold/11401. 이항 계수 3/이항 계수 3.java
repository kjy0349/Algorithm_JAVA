import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long NUM = 1_000_000_007;
    public static long fastPow(long a, long b) {
        long ret = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ret = (ret * a) % NUM;
            }
            a = (a * a) % NUM;
            b >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long nComb = 1;
        long rComb = 1;
        long nrComb = 1;
        long start = N;
        while (N > 0) {
            nComb = (nComb * N) % NUM;
            if (N <= R) rComb = (rComb * N) % NUM;
            if (N <= start - R) nrComb = (nrComb * N) % NUM;
            N--;
        }
        sb.append((fastPow((nrComb * rComb) % NUM, NUM - 2) * nComb) % NUM).append("\n");
        System.out.print(sb);
    }
}