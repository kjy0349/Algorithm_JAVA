package study_42;
import java.io.*;

public class P_1010 {
    static int N;
    static int M;
    static long answer;
    public static void comb(int N, int R) {
        if (R > N)
            answer = 0;
        else {
            answer = 1;
            for (int i = 1; i < R + 1; i++) {
                answer *= (N - i + 1);
                answer /= i;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            comb(M, N);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
