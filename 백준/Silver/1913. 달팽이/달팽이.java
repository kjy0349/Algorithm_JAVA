import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int target;
    static int[] answer;
    public static void dfs(int x, int y, int dir, int start) {
        if (start >= 1) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = start;
                    if (arr[nx][ny] == target) {
                        answer[0] = nx + 1;
                        answer[1] = ny + 1;
                    }
                    dfs(nx, ny, dir, start - 1);
                } else dfs(x, y, (dir + 1) % 4, start);
            } else {
                dfs(x, y, (dir + 1) % 4, start);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        answer = new int[2];
        int start = N * N;
        dfs(-1, 0, 0, start);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) bw.write(arr[i][j] + " ");
            bw.write(arr[i][arr[0].length - 1] + "\n");
        }
        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
    }
}