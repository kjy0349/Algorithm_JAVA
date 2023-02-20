package study_42;

import java.io.*;
import java.util.Arrays;

public class Review_20230220 {
    static class Turret {
        public static void solve() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x1 = inputs[0];
                int y1 = inputs[1];
                int r1 = inputs[2];
                int x2 = inputs[3];
                int y2 = inputs[4];
                int r2 = inputs[5];
                double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                if (x1 == x2 && y1 == y2 && r1 == r2) bw.write("-1\n");
                else if (r1 + r2 > d && Math.abs(r1 - r2) < d) bw.write("2\n");
                else if (r1 + r2 == d || (r1 + r2 > d && Math.abs(r1 - r2) == d)) bw.write("1\n");
                else bw.write("0\n");
            }
            bw.flush();
        }
    }

    static class YoungPrincess {
        public static void solve() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x1 = inputs[0];
                int y1 = inputs[1];
                int x2 = inputs[2];
                int y2 = inputs[3];
                int n = Integer.parseInt(br.readLine());
                int answer = 0;
                for (int j = 0; j < n; j++) {
                    inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    int cx = inputs[0];
                    int cy = inputs[1];
                    int r = inputs[2];
                    double f_dist = Math.sqrt(Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2));
                    double s_dist = Math.sqrt(Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2));
                    if (!((f_dist > r && s_dist > r) || (f_dist < r && s_dist < r))) answer++;
                }
                bw.write(answer + "\n");
            }
            bw.flush();
        }
    }

    static class PolyBridge {
        public static void solve() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int N = inputs[0];
                int M = inputs[1];
                if (N > M) bw.write("0\n");
                else {
                    long answer = 1;
                    for (int j = 1; j < N + 1; j++) {
                        answer *= M - j + 1;
                        answer /= j;
                    }
                    bw.write(answer + "\n");
                }
            }
            bw.flush();
        }
    }

    public static void main(String[] args) throws IOException{
        PolyBridge.solve();
    }
}
