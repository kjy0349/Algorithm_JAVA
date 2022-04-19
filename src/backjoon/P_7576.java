package backjoon;
import java.io.*;
import java.util.*;

class Cords{
    int x;
    int y;
    Cords(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class P_7576 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void bfs(Queue<Cords> q, int[][] tomato, int[][] map){
        while (!q.isEmpty()){
            Cords current = q.poll();
            for (int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < tomato.length && ny >= 0 && ny < tomato[0].length){
                    if (tomato[nx][ny] == 0 && map[nx][ny] == -1){ // 토마토가 익지 않은 상태
                        q.add(new Cords(nx, ny));
                        map[nx][ny] = map[current.x][current.y] + 1;
                        tomato[nx][ny] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = inputs[0];
        int N = inputs[1];
        int[][] tomato = new int[N][M];
        int[][] map = new int[N][M];
        boolean is_finish = true;
        for (int i = 0;i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0;j < M;j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = -1;
            }
        }
        Queue<Cords> q = new LinkedList<>();
        for (int i = 0;i < N;i++){
            for (int j = 0;j < M;j++){
                if (tomato[i][j] == 1) {
                    q.add(new Cords(i, j));
                    map[i][j] = 0;
                }
            }
        }
        bfs(q, tomato, map);
        int est_days = 0;
        for (int i = 0;i < N;i++){
            for (int j = 0;j < M ;j++){
                if (tomato[i][j] == 0) {
                    is_finish = false;
                    break ;
                }
                if (map[i][j] > est_days) est_days = map[i][j];
            }
            if (!is_finish) break;
        }
        if (!is_finish) System.out.println(-1);
        else System.out.println(est_days);
    }
}

