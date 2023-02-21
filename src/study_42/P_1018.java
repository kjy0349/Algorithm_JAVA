package study_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_1018 {
    static String[][] map;
    static int answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Cord {
        int x;
        int y;
        String color;
        Cord(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void solve(int x, int y, String type) { // type 0 : white, 1 : black
        Queue<Cord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];
        queue.add(new Cord(x, y, type));
        visited[0][0] = true;
        int result = 0;
        if (!map[x][y].equals(type)) result++;
        while (!queue.isEmpty()) {
            Cord elem = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (nx >= x && ny >= y && nx < x + 8 && ny < y + 8 && !visited[nx - x][ny - y]) {
                    visited[nx - x][ny - y] = true;
                    if (map[nx][ny].equals(elem.color)) {
                        result++;
                        queue.add(new Cord(nx, ny, map[nx][ny].equals("W") ? "B" : "W"));
                    } else queue.add(new Cord(nx, ny, map[nx][ny]));
                }
            }
        }
        if (result < answer) answer = result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        answer = 2147483647;
        map = new String[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 < N && j + 7 < M) {
                    solve(i, j, map[i][j]);
                    solve(i, j, map[i][j].equals("W") ? "B" : "W");
                }
            }
        }
        System.out.println(answer);
    }
}
