package backjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P_15685 {
    public static ArrayList<Integer> make_dirs(int dir, int gen, boolean[][] map) {
        ArrayList<Integer> dirs = new ArrayList<>();
        dirs.add(dir);
        for (int i = 0; i < gen; i++) {
            ArrayList<Integer> temp = new ArrayList<>(dirs);
            Collections.reverse(temp);
            for (int j = 0;j < temp.size();j++) {
                int next_dir = (temp.get(j) + 1) % 4;
                temp.set(j, next_dir);
            }
            dirs.addAll(temp);
        }
        return dirs;
    }

    public static void main(String[] args) throws IOException{
        // 0:동 1:북 2:서 3:남
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dragon = new int[4];
        boolean[][] map = new boolean[101][101];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int[] chk_x = {1, 0, 1};
        int[] chk_y = {0, 1, 1};
        for (int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < 4;j++) dragon[j] = Integer.parseInt(st.nextToken());
            ArrayList<Integer> dirs = make_dirs(dragon[2], dragon[3], map);
            int x = dragon[0];
            int y = dragon[1];
            map[y][x] = true;
            for (Integer dir : dirs) {
                x += dx[dir];
                y += dy[dir];
                map[y][x] = true;
            }
        }
        int count = 0;
        for (int i = 0;i < map.length;i++) {
            for (int j = 0;j < map[0].length;j++) {
                if (map[i][j]) {
                    boolean is_poss = true;
                    for (int k = 0;k < 3;k++) {
                        int nx = j + chk_x[k];
                        int ny = i + chk_y[k];
                        if (nx > 100 || ny > 100 || !map[ny][nx]) {
                            is_poss = false;
                            break ;
                        }
                    }
                    if (is_poss) count++;
                 }
            }
        }
        System.out.println(count);
    }
}
