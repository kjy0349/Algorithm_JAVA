package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P_16197{
    static class Cord {
        int x;
        int y;
        int count;
        Cord(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] map;

    public static int bfs(ArrayList<Cord> coins) {
        Queue<Cord> fir = new LinkedList<>();
        Queue<Cord> sec = new LinkedList<>();
        fir.add(coins.get(0));
        sec.add(coins.get(1));
        while (!fir.isEmpty() && !sec.isEmpty())
        { // 남 북 동 서
            Cord first = fir.poll();
            Cord second = sec.poll();
            int fx = first.x;
            int fy = first.y;
            int sx = second.x;
            int sy = second.y;
            if (first.count >= 10) break;
            for (int i = 0; i < 4; i++) {
                int fnx = fx + dx[i];
                int fny = fy + dy[i];
                int snx = sx + dx[i];
                int sny = sy + dy[i];
                boolean in_f = (fnx >= 0 && fnx < map.length && fny >= 0 && fny < map[0].length);
                boolean in_s = (snx >= 0 && snx < map.length && sny >= 0 && sny < map[0].length);
                if (in_f ^ in_s) return (first.count + 1);
                else { // 0 0, 1 1
                    if (in_f) // 1 1
                    {
                        if (map[fnx][fny].equals("#") && !map[snx][sny].equals("#")) {
                            fir.add(new Cord(fx, fy, first.count + 1));
                            sec.add(new Cord(snx, sny, second.count + 1));
                        } else if (!map[fnx][fny].equals("#") && map[snx][sny].equals("#")) {
                            sec.add(new Cord(sx, sy, first.count + 1));
                            fir.add(new Cord(fnx, fny, second.count + 1));
                        } else if (!map[fnx][fny].equals("#") && !map[snx][sny].equals("#")) {
                            fir.add(new Cord(fnx, fny, first.count + 1));
                            sec.add(new Cord(snx, sny, second.count + 1));
                        }
                    }
                }
            }
        }
        return (-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        ArrayList<Cord> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] elem = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = elem[j];
                if (map[i][j].equals("o")) coins.add(new Cord(i, j, 0));
            }
        }
        System.out.println(bfs(coins));
    }
}