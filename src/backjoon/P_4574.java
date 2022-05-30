package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_4574 {
    static int step = 0;
    static int[][] map = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static int[] get_cord(String cord) {
        int x = cord.charAt(0) - 'A';
        int y = cord.charAt(1) - '1';
        return new int[]{x, y};
    }

    public static boolean make_domino(int x, int y, int nx, int ny) {
        for (int i = 1; i < 10; i++) {
            if (is_poss(x, y, i)) map[x][y] = i;
            for (int j = 1; j < 10; j++) {
                if (is_poss(nx, ny, j)) {
                    map[nx][ny] = j;
                    return true;
                }
            }
            map[x][y] = 0;
        }
        return false;
    }

    public static boolean is_poss(int x, int y, int num) {
        boolean is_pos = true;
        ArrayList<Integer> check = new ArrayList<>();
        for (int i = 0; i < 9; i++) check.add(map[x][i]);
        if (check.contains(num)) is_pos = false;
        if (is_pos) {
            check.clear();
            for (int i = 0; i < 9; i++) check.add(map[i][y]);
            if (check.contains(num)) is_pos = false;
        }
        if (is_pos) {
            check.clear();
            int sx = (x / 3) * 3;
            int sy = (y / 3) * 3;
            for (int i = sx; i < sx + 3; i++) {
                for (int j = sy; j < sy + 3;j++) check.add(map[i][j]);
            }
            if (check.contains(num)) is_pos = false;
        }
        return is_pos;
    }

    public static void solve_puz(int count, int sx) throws IOException{
        if (count == 0) {
            bw.write("Puzzle " + step + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(map[i][j]));
                }
                bw.newLine();
            }
        } else {
            bw.write("Puzzle " + step + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(map[i][j]));
                }
                bw.newLine();
                bw.flush();
            }
            for (int i = sx; i < 9; i++) {
                boolean quit = false;
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 0) {
                        for (int k = 0; k < 2; k++) {
                            boolean pos;
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < 9 && ny >= 0 && ny < 9 && map[nx][ny] == 0) { // i,j && nx,ny에 도미노 삽입
                                pos = make_domino(i, j, nx, ny);
                                quit |= pos;
                                if (pos) solve_puz(count - 1, i);
                                map[i][j] = 0;
                                map[nx][ny] = 0;
                            }
                        }
                    }
                    if (!quit) break;
                    }
                if (!quit) break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        StringTokenizer st;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            step++;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    int[] cord = get_cord(st.nextToken());
                    map[cord[0]][cord[1]] = num;
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 10; i++) {
                int[] cord = get_cord(st.nextToken());
                map[cord[0]][cord[1]] = i;
            }
            int count = (72 - (N * 2)) / 2; // 추가해야 할 도미노의 개수
            solve_puz(count, 0);
            bw.flush();
        }
    }
}
