package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_16931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int area = 0;
        int[][] map = new int[N][M];
        for (int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < M;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        area += N * M + 2;

        System.out.println(area);
    }
}
