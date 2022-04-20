package backjoon;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Vnc {
    int vertex;
    int clip;
    Vnc (int vertex, int clip) {
        this.vertex = vertex;
        this.clip = clip;
    }
}

public class P_14226 {
    static int MAX = 2000;

    public static void bfs(int[][] map, boolean[][] visited) {
        Queue<Vnc> q = new LinkedList<>();
        q.add(new Vnc(1, 0));
        visited[1][0] = true;
        while (!q.isEmpty()) {
            Vnc cur = q.poll();
            int v = cur.vertex;
            int c = cur.clip;
            if (!visited[v][v]) {
                visited[v][v] = true;
                q.add(new Vnc(v, v));
                map[v][v] = map[v][c] + 1;
            }
            if (v + c < MAX) {
                if (!visited[v + c][c]) {
                    visited[v + c][c] = true;
                    q.add(new Vnc(v + c, c));
                    map[v + c][c] = map[v][c] + 1;
                }
            }
            if (v - 1 >= 0) {
                if (!visited[v - 1][c]) {
                    visited[v - 1][c] = true;
                    q.add(new Vnc(v - 1, c));
                    map[v - 1][c] = map[v][c] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[][] map = new int[MAX][MAX];
        boolean[][] visited = new boolean[MAX][MAX];
        bfs(map, visited);
        int min = 2147483647;
        for (int i = 0; i < map[S].length; i++) {
            if (min > map[S][i] && visited[S][i]) min = map[S][i];
        }
        System.out.println(min);
    }
}
