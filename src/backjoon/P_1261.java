package backjoon;
import java.util.*;
import java.io.*;

class Cordc {
    int x;
    int y;
    Cordc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class P_1261 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = inputs[0];
        int N = inputs[1];
        int[][] maze = new int[N][M];
        int[][] count = new int[N][M];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = tmp.charAt(j) - '0';
                count[i][j] = -1;
            }
        }
        Deque<Cordc> dq = new LinkedList<>();
        dq.add(new Cordc(0, 0));
        count[0][0] = 0;
        while (!dq.isEmpty()) {
            Cordc cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (count[nx][ny] == -1) {
                        if (maze[nx][ny] == 0) {
                            dq.addFirst(new Cordc(nx, ny));
                            count[nx][ny] = count[cur.x][cur.y];
                        }
                        if (maze[nx][ny] == 1) {
                            dq.addLast(new Cordc(nx, ny));
                            count[nx][ny] = count[cur.x][cur.y] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(count[N - 1][M - 1]);
    }
}
