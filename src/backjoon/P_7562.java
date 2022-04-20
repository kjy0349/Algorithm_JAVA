package backjoon;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Cordb {
    int x;
    int y;
    Cordb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P_7562 {
    static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static void bfs(Cordb start, boolean[][] visited, int[][] times) {
        Queue<Cordb> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Cordb cur = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited.length) {
                    if (!visited[nx][ny]) {
                        q.add(new Cordb(nx, ny));
                        visited[nx][ny] = true;
                        times[nx][ny] = times[cur.x][cur.y] + 1;
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[I][I];
            int[][] times = new int[I][I];
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Cordb cur = new Cordb(inputs[0], inputs[1]);
            bfs(cur, visited, times);
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(times[inputs[0]][inputs[1]] + "\n");
        }
        bw.flush();
    }
}
