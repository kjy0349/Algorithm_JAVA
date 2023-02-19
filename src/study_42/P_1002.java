package study_42;
import java.io.*;
import java.util.Arrays;

public class P_1002 {
    static class Circle {
        int x;
        int y;
        int r;
        Circle (int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Circle fir = new Circle(inputs[0], inputs[1], inputs[2]);
            Circle sec = new Circle(inputs[3], inputs[4], inputs[5]);
            double dist = Math.sqrt(Math.pow(fir.x - sec.x, 2) + Math.pow(fir.y - sec.y, 2));
            if (dist == 0 && fir.r == sec.r) bw.write("-1\n");
            else if (dist == 0) bw.write("0\n");
            else if (fir.r + sec.r > dist && Math.abs(fir.r - sec.r) < dist) bw.write("2\n");
            else if (fir.r + sec.r < dist || Math.abs(fir.r - sec.r) > dist) bw.write("0\n");
            else if (fir.r + sec.r == dist || Math.abs(fir.r - sec.r) == dist) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();
    }
}
