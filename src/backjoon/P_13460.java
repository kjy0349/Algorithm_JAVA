package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_13460 {
    static class Ball {
        int x;
        int y;
        int count;

        public Ball(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; // 0 : 동, 1 : 서, 2 : 남, 3 : 북
    static boolean[][][][] visited;
    static Ball blue;
    static Ball red;

    public static void roll(Ball blue, Ball red, int direction) {
        Ball fir = blue;
        Ball sec = red;
        switch (direction) {
            case 0:
                fir = blue.y > red.y ? blue : red;
                sec = blue.y <= red.y ? blue : red;
                break;
            case 1:
                fir = blue.y < red.y ? blue : red;
                sec = blue.y >= red.y ? blue : red;
                break;
            case 2:
                fir = blue.x > red.x ? blue : red;
                sec = blue.x <= red.x ? blue : red;
                break;
            case 3:
                fir = blue.x > red.x ? red : blue;
                sec = blue.x <= red.x ? red : blue;
                break;
        }

        while (map[fir.x + dx[direction]][fir.y + dy[direction]].equals(".") ||
                map[fir.x + dx[direction]][fir.y + dy[direction]].equals("O")) {
            fir.x += dx[direction];
            fir.y += dy[direction];
            if (map[fir.x][fir.y].equals("O")) break;
        }

        while (map[sec.x + dx[direction]][sec.y + dy[direction]].equals(".") ||
                        map[sec.x + dx[direction]][sec.y + dy[direction]].equals("O")) {
            if (map[sec.x + dx[direction]][sec.y + dy[direction]].equals("O")) {
                sec.x += dx[direction];
                sec.y += dy[direction];
                break;
            } else if (fir.x != sec.x + dx[direction] || fir.y != sec.y + dy[direction]) {
                sec.x += dx[direction];
                sec.y += dy[direction];
            } else break;
        }
    }

    public static int bfs(Ball blue, Ball red) {
        Queue<Ball> b_queue = new LinkedList<>();
        Queue<Ball> r_queue = new LinkedList<>();
        b_queue.add(blue);
        r_queue.add(red);
        while ((!b_queue.isEmpty() || !r_queue.isEmpty())) {
            Ball b = b_queue.poll();
            Ball r = r_queue.poll();
            boolean poss = false;
            for (int i = 0; i < 4; i++) {
                Ball bl = new Ball(b.x, b.y, b.count);
                Ball rl = new Ball(r.x, r.y, r.count);
                bl.count++;
                roll(bl, rl, i);
                if (!visited[rl.x][rl.y][bl.x][bl.y] && !map[bl.x][bl.y].equals("O") && (bl.count <= 10))
                {
                    visited[rl.x][rl.y][bl.x][bl.y] = true;
                    b_queue.add(bl);
                    r_queue.add(rl);
                    poss = map[rl.x][rl.y].equals("O") && map[bl.x][bl.y].equals(".");
                }
                if (poss) return bl.count;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        map = new String[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if (line[j].equals("B")) {
                    blue = new Ball(i, j, 0);
                    map[i][j] = ".";
                } else if (line[j].equals("R")) {
                    red = new Ball(i, j, 1);
                    map[i][j] = ".";
                }
            }
        }
        visited[red.x][red.y][blue.x][blue.y] = true;
        System.out.println(bfs(blue, red));
    }
}