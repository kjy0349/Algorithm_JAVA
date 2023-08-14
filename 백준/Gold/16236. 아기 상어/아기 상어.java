import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[][];
    static int map[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<Fish> poss;
    static Shark now;
    static int answer;
    static class Cord {
        int x;
        int y;
        Cord (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish extends Cord{
        int distance;

        Fish(int x, int y, int distance) {
            super(x, y);
            this.distance = distance;
        }
    }

    static class Shark extends Fish {
        int size;
        int count;

        Shark(int x, int y, int distance, int size, int count) {
            super(x, y, distance);
            this.size = size;
            this.count = count;
        }
    }

    public static boolean bfs(Shark now) {
        visited = new boolean[map.length][map[0].length];
        visited[now.x][now.y] = true;
        Queue<Shark> que = new ArrayDeque<>();
        que.add(now);
        while (!que.isEmpty()) {
            Shark elem = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = elem.x + dx[i];
                int ny = elem.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length
                && !visited[nx][ny] && map[nx][ny] <= elem.size) {
                    if (map[nx][ny] > 0) {
                        if (poss.isEmpty()) {
                            if (elem.size > map[nx][ny]) poss.offer(new Fish(nx, ny, elem.distance + 1));
                        } else {
                            if (elem.size > map[nx][ny]) {
                                Fish tmp = poss.peek();
                                if (elem.distance + 1 < tmp.distance) {
                                    poss.poll();
                                    poss.offer(new Fish(nx, ny, elem.distance + 1));
                                } else if (elem.distance + 1 == tmp.distance) {
                                    if (elem.x < tmp.x) {
                                        poss.poll();
                                        poss.offer(new Fish(nx, ny, elem.distance + 1));
                                    } else if (elem.x == tmp.x && elem.y < tmp.y) {
                                        poss.poll();
                                        poss.offer(new Fish(nx, ny, elem.distance + 1));
                                    }
                                }
                            }
                        }
                    }
                    visited[nx][ny] = true;
                    que.add(new Shark(nx, ny, elem.distance + 1, elem.size, elem.count));
                }
            }
        }
        if (!poss.isEmpty()) {
            Fish target = poss.poll();
            answer += target.distance;
            map[target.x][target.y] = 0;
            now.x = target.x;
            now.y = target.y;
            now.distance = 0;
            now.count += 1;
            if (now.count == now.size) {
                now.size += 1;
                now.count = 0;
            }
            return true;
        } else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        visited = new boolean[N][N];
        poss = new ArrayDeque<>();
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    now = new Shark(i, j, 0, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            if (!bfs(now)) {
                break;
            }
        }
        System.out.println(answer);
    }
}
