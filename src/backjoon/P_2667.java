package backjoon;
import java.io.*;
import java.util.*;

class Cord{
    int x;
    int y;
    Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class P_2667 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static int bfs(Cord cord, int[][] map, int cnt){
        int count = 1;
        Queue<Cord> q = new LinkedList<>();
        q.add(cord);
        map[cord.x][cord.y] = cnt;
        while (!q.isEmpty()) {
            Cord cur = q.poll();
            for (int i = 0;i < 4;i++){
                int cx = cur.x + dx[i];
                int cy = cur.y + dy[i];
                if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[cx].length && map[cx][cy] == 1) {
                    q.add(new Cord(cx, cy));
                    map[cx][cy] = cnt;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int cnt = 2;
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0;i < N;i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0;i < map.length;i++) {
            for (int j = 0;j < map[i].length;j++) {
                if (map[i][j] == 1) {
                    answers.add(bfs(new Cord(i, j), map, cnt++));
                }
            }
        }
        Collections.sort(answers);
        bw.write(answers.size() + "\n");
        for (int elem : answers) bw.write(elem + "\n");
        bw.flush();
    }
}
