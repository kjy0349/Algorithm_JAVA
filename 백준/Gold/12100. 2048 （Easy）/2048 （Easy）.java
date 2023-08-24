import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] dy = {1, -1, 0, 0};

    static int answer = 0;

    static class C_map {
        int[][] map;
        int count;

        public C_map(int[][] map, int count) {
            this.map = map;
            this.count = count;
        }
    }

    public static int roll(C_map temp, int direction) {
        int[][] map = temp.map;
        int max = 0;
        boolean[][] m_visited = new boolean[map.length][map[0].length];
        if (direction == 0 || direction == 1) { // 동, 서
            int y = 0;
            if (direction == 0) y = map[0].length - 2;
            for (int i = 0; i < map.length; i++) { // 동이면 j > 0, 서면 j < map의 가로 인덱스 끝
                for (int j = y; direction == 0 ? j >= 0 : j < map[0].length ; j -= dy[direction]) {
                    int cur = map[i][j];
                    if (cur > 0) {
                        if (max < cur) max = cur;
                        int counter = 0;
                        boolean move = false;
                        for (int k = j + dy[direction]; direction == 0 ? k < map[0].length : k >= 0; k += dy[direction]) {
                            int nxt = map[i][k];
                            if (nxt == 0) {
                                move = true;
                                counter++;
                            } else if (nxt == cur && !m_visited[i][k]) {
                                m_visited[i][k] = true;
                                move = false;
                                map[i][k] *= 2;
                                map[i][j] = 0;
                                if (max < cur * 2) max = cur * 2;
                                break;
                            } else break;
                        }
                        if (move) {
                            map[i][j] = 0;
                            map[i][j + (counter * dy[direction])] = cur;
                        }
                    }
                }
            }
        } else {
            int x = map.length - 1;
            int y = 0;
            if (direction == 3) x = 1; // 북쪽
            for (int i = x; direction == 2 ? i >= 0 : i < map.length ; i -= dx[direction]) {
                for (int j = y; j < map[0].length; j++) {
                    int cur = map[i][j];
                    if (cur > 0) {
                        if (max < cur) max = cur;
                        int counter = 0;
                        boolean move = false;
                        for (int k = i + dx[direction]; direction == 2 ? k < map.length : k >= 0; k += dx[direction]) {
                            int nxt = map[k][j];
                            if (nxt == 0) {
                                move = true;
                                counter++;
                            } else if (nxt == cur && !m_visited[k][j]) {
                                m_visited[k][j] = true;
                                move = false;
                                map[k][j] *= 2;
                                map[i][j] = 0;
                                if (max < cur * 2) max = cur * 2;
                                break;
                            } else break;
                        }
                        if (move) {
                            map[i][j] = 0;
                            map[i + counter * dx[direction]][j] = cur;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void bfs(int[][] map) {
        Queue<C_map> mapQueue = new LinkedList<>();
        int[][] tt_map = new int[map.length][map[0].length];
        for (int j = 0; j < tt_map.length; j++) {
            System.arraycopy(map[j], 0, tt_map[j], 0, tt_map[0].length);
        }
        mapQueue.add(new C_map(map, 0));
        while (!mapQueue.isEmpty()) {
            C_map target = mapQueue.poll();
            for (int i = 0; i < 4; i++) {
                int[][] temp_map = new int[target.map.length][target.map[0].length];
                for (int j = 0; j < temp_map.length; j++) {
                    System.arraycopy(target.map[j], 0, temp_map[j], 0, temp_map[0].length);
                }
                C_map temp = new C_map(temp_map, target.count);
                int max = roll(temp, i);
                temp.count++;
                if (max > answer) answer = max;
                if (temp.count < 5) mapQueue.add(temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        bfs(map);
        System.out.println(answer);
    }
}
