package backjoon;
import java.io.*;
import java.util.StringTokenizer;

class Curr {
    int x;
    int y;
    Curr(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P_14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        // 1:벽, 0:청소 안됨, 2: 청소 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Curr cur = new Curr(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int dir = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int cleaned = 0;
        while (true) {
            boolean finished = false;
            int exec = 0;
            // 1번
            if (map[cur.x][cur.y] == 0){
                map[cur.x][cur.y] = 2;
                cleaned++;
            }
            // 2번
            // 0:북, 1:동, 2:남, 3:서
            while (true) {
                if (exec != 4) {
                    int chk_ind = (dir + 3) % 4;
                    int nx = cur.x + dx[chk_ind];
                    int ny = cur.y + dy[chk_ind];
                    dir = chk_ind;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        cur.x = nx;
                        cur.y = ny;
                        break;
                    }
                    exec++;
                }
                else {
                    exec = 0;
                    int back_ind = (dir + 2) % 4;
                    if (map[cur.x + dx[back_ind]][cur.y + dy[back_ind]] == 1) {
                        finished = true;
                        break;
                    }
                    cur.x += dx[(dir + 2) % 4];
                    cur.y += dy[(dir + 2) % 4];
                }
            }
            if (finished) break;
        }
        System.out.println(cleaned);
    }
}
