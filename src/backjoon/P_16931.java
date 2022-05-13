package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_16931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[102][102];
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1;j <= M;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int area = N * M * 2;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (map[i][j] - map[nx][ny] > 0) area += map[i][j] - map[nx][ny];
                }
            }
        }
        System.out.println(area);
    }
}
