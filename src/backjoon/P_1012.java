package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_1012 {
    static int[][] field;
    static boolean[][] visited;
    static int answer;
    static int[] dx = new int[]{1, 0, 0, -1};
    static int[] dy = new int[]{0, 1, -1, 0};
    static int N;
    static int M;

    static class Cord {
        int x;
        int y;
        Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int j, int k) {
        Queue<Cord> queue = new LinkedList<>();
        visited[j][k] = true;
        queue.add(new Cord(j, k));
        while (!queue.isEmpty()) {
            Cord cord = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cord.x + dx[i];
                int ny = cord.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && field[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Cord(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = inputs[0];
            N = inputs[1];
            int K = inputs[2];
            field = new int[N][M];
            visited = new boolean[N][M];
            answer = 0;
            for (int j = 0; j < K; j++) {
                int[] cord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                field[cord[1]][cord[0]] = 1;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[j][k] && field[j][k] == 1) {
                        answer++;
                        bfs(j, k);
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
