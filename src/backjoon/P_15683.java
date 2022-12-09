package backjoon;
import java.util.Arrays;
import java.util.Scanner;

public class P_15683 {
    static int[][] map;
    static int answer;
    static int N;
    static int M;
    static int[] dx = new int[]{0, 0, 1, -1}; // 동 서 남 북
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void go(int x, int y, int dir, int is_set) { // is_set이 #이면 #화, 0이면 0화
        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
            map[x][y] = is_set;
            go(x + dx[dir], y + dy[dir], dir, is_set);
        }
    }
    public static void one(int x, int y) {
        int min = answer;
        int target_dir = -1;
        for (int i = 0; i < 4; i++) {
            int tx = x;
            int ty = y;
            int tmp = answer;
            while (true) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {
                    if (map[nx][ny] == 0) {
                        tmp--;
                        map[nx][ny] = '#';
                    }
                    tx = nx;
                    ty = ny;
                } else break;
            }
            if (tmp < min) {
                min = tmp;
                target_dir = i;
            }
            go(x, y, i, 0);
        }
        go(x, y, target_dir, '#');
        answer = min;
    }
    public static void two(int x, int y) {
        //동서 or 남북 0 1, 2 3
        int min = answer;
        int target_dir = -1;
        for (int i = 0; i < 2; i++) {
            int tx = x;
            int ty = y;
            int tmp = answer;
            while (true) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][n₩y] != 6) {
                    if (map[nx][ny] == 0) {
                        tmp--;
                        map[nx][ny] = '#';
                    }
                    tx = nx;
                    ty = ny;
                } else break;
            }
            if (tmp < min) {
                min = tmp;
                target_dir = i;
            }
            go(x, y, i, 0);
        }
        go(x, y, target_dir, '#');
        answer = min;
    }
    public static void get_max(int num, int i, int j) {
        switch (num) {
            case 1:
                one(i, j);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        map = new int[N][M];
        answer = N * M;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
                if (map[i][j] > 0) answer--;
            }
            scan.nextLine();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] != 6) {
                    get_max(map[i][j], i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
