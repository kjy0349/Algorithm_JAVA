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
        int color; // 0 : BLUE, 1 : RED
        int count;

        public Ball(int x, int y, int color, int count) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.count = count;
        }
    }

    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; // 동 서 남 북
    static Ball blue;
    static Ball red;

    public static int bfs(Ball blue, Ball red) {
        Queue<Ball> b_queue = new LinkedList<>();
        Queue<Ball> r_queue = new LinkedList<>();
        b_queue.add(blue);
        r_queue.add(red);
        while ((!b_queue.isEmpty() && !r_queue.isEmpty())) {
            Ball b = b_queue.poll();
            Ball r = r_queue.poll();
            if (b.count == 10) return -1;
            boolean poss;
            for (int i = 0; i < 4; i++) {
                if (i == 0) {

                }
                while (!map[b.x + dx[i]][b.y + dx[i]].equals("#")) {
//                    b.
                }
                int bx = b.x - dx[i];
                int by = b.y - dy[i];
                int rx = r.x - dx[i];
                int ry = r.y - dy[i];
                if (bx >= 0 && by >= 0 && by < map[0].length &&
                        rx >= 0 && ry >= 0 && ry < map[0].length) {
                    b.count++;
                    r.count++;
                    if (!map[bx][by].equals("#")) {
                        b.x = bx;
                        b.y = by;
                    }
                    if (!map[rx][ry].equals("#"))
                    {
                        r.x = rx;
                        r.y = ry;
                    }
                    if (b.x != r.x || b.y != r.y) {
                        b_queue.add(b);
                        r_queue.add(r);
                    }
                    poss = map[r.x][r.y].equals("O") && map[b.x][b.y].equals(".");
                    if (poss) return r.count;
                }
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
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if (line[j].equals("B")) {
                    blue = new Ball(i, j, 0,0);
                    map[i][j] = ".";
                } else if (line[j].equals("R")) {
                    red = new Ball(i, j, 1, 0);
                    map[i][j] = ".";
                }
            }
        }
        System.out.println(bfs(blue, red));
    }
}
