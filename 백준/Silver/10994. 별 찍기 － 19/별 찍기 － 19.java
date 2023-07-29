import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static String[][] result;
    static boolean[][] visited;
    static class Cord {
        int x;
        int y;
        boolean type;
        Cord(int x, int y, boolean type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public static void find_sol(int x, int y, boolean type) {
        Queue<Cord> que = new LinkedList<>();
        que.add(new Cord(x, y, type));
        while (!que.isEmpty()) {
            Cord cord = que.poll();
            result[cord.x][cord.y] = !cord.type ? "*" : " ";
            for (int i = 0; i < dx.length; i++) {
                int nx = cord.x + dx[i];
                int ny = cord.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < result.length && ny < result.length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new Cord(nx, ny, !cord.type));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        result = new String[4 *(N - 1) + 1][4 *(N - 1) + 1];
        visited = new boolean[result.length][result[0].length];
        int x, y;
        x = y = result.length / 2;
        find_sol(x, y, false);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) bw.write(result[i][j]);
            bw.newLine();
        }
        bw.flush();
    }
}