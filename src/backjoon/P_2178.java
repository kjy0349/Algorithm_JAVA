package backjoon;
import java.io.*;
import java.util.*;

class Cordi{
    int x;
    int y;
    Cordi(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class P_2178 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void bfs(Cordi cord, int[][] distance, int[][] map){
        Queue<Cordi> q = new LinkedList<>();
        q.add(cord);
        distance[cord.x][cord.y] = 1;
        while (!q.isEmpty()){
            Cordi cur = q.poll();
            for (int i = 0;i < 4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < distance.length && ny >= 0 && ny < distance[0].length) {
                    if (map[nx][ny] == 1 && distance[nx][ny] == -1)
                    {
                        q.add(new Cordi(nx, ny));
                        distance[nx][ny] = distance[cur.x][cur.y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int[][] map = new int[N][M];
        for (int i = 0;i < N;i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[][] distance = new int[N][M];
        for (int[] elem : distance) Arrays.fill(elem, -1);
        bfs(new Cordi(0, 0), distance, map);
        System.out.println(distance[N - 1][M - 1]);
    }
}
