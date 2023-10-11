import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long NUM = 1000000007;
    public static long fastPow(long a, long b) {
        if (b == 0) return 1;
        long ret = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ret = ((ret % NUM) * (a % NUM)) % NUM;
            }
            a = ((a % NUM) * (a % NUM)) % NUM;
            b >>= 1;
        }
        return ret;
    }
    public static long factorial(long N) {
        long ret = 1;
        while (N > 0) {
            ret = ((ret % NUM) * (N % NUM)) % NUM;
            N--;
        }
        return ret;
    }

    public static long solve(long N, long R) {
        long answer = factorial(N);
        long subMul = fastPow((factorial(N - R) * factorial(R)) % NUM, NUM - 2);
        answer = ((answer % NUM) * (subMul % NUM)) % NUM;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long answer = solve(N, R);
        System.out.print(answer);
    }
}