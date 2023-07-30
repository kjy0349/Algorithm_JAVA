import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] arr;
    static int all_count;
    public static void find_sol(int x, int y, int dir, int count, int before) {
        if (count != all_count) {
            if (dir == 4) {
                dir = 0;
                x++;
                y++;
                if (x < arr.length && y < arr[0].length &&!visited[x][y]) find_sol(x, y, dir, count, arr[x][y]);
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int tmp = arr[nx][ny];
                    arr[nx][ny] = before;
                    before = tmp;
                    find_sol(nx, ny, dir, count + 1, before);
                } else find_sol(x, y, dir + 1, count, before);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        all_count = N * M;
        for (int i = 0; i < N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int k = 0; k < R; k++) {
            visited = new boolean[N][M];
            find_sol(0, 0, 0, 0, arr[0][0]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) bw.write(arr[i][j] + " ");
            bw.write(Integer.toString(arr[i][arr[0].length - 1]));
            bw.newLine();
        }
        bw.flush();
    }
}