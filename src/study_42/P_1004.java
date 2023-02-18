package study_42;

import java.io.*;
import java.util.Arrays;

public class P_1004 {
    static class Cord {
        int x;
        int y;
        Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] dots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = Integer.parseInt(br.readLine());
            Cord start = new Cord(dots[0], dots[1]);
            Cord dest = new Cord(dots[2], dots[3]);
            int answer = 0;
            for (int j = 0; j < n; j++) {
                int[] circle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = circle[0];
                int y = circle[1];
                int r = circle[2];
                double s_dist = Math.sqrt(Math.pow(start.x - x, 2) + Math.pow(start.y - y, 2));
                double d_dist = Math.sqrt(Math.pow(dest.x - x, 2) + Math.pow(dest.y - y, 2));
                if (s_dist < r && d_dist < r) {}
                else if (s_dist < r) answer++;
                else if (d_dist < r) answer++;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
