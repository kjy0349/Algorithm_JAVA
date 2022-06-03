package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_4574_min {
    static int step = 0;
    static int[][] map;
    static boolean[][] domino;
    static boolean print_once;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> check = new ArrayList<>();

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static int[] get_cord(String cord) {
        int x = cord.charAt(0) - 'A';
        int y = cord.charAt(1) - '1';
        return new int[]{x, y};
    }

    public static boolean is_poss(int x, int y, int num) {
        boolean is_poss = true;
        check.clear();
        for (int i = 0; i < 9; i++) check.add(map[x][i]);
        if (check.contains(num)) is_poss = false;
        if (is_poss) {
            check.clear();
            for (int i = 0; i < 9; i++) check.add(map[i][y]);
            if (check.contains(num)) is_poss = false;
        }
        if (is_poss) {
            check.clear();
            int sx = (x / 3) * 3;
            int sy = (y / 3) * 3;
            for (int i = sx; i < sx + 3; i++) {
                for (int j = sy; j < sy + 3; j++) check.add(map[i][j]);
            }
            if (check.contains(num)) is_poss = false;
        }
        return is_poss;
    }

    public static void solve_puz(int count, int sx) throws IOException{
        if (count == 0 && !print_once) {
            print_once = true;
            bw.write("Puzzle " + step + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(map[i][j]));
                }
                bw.newLine();
            }
        } else {
            for (int i = sx; i < 9; i++) {
                boolean is_poss = true;
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 0) {
                        for (int k = 0; k < 2; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < 9 && ny >= 0 && ny < 9 && map[nx][ny] == 0) {
                                for (int l = 1; l < 10; l++) {
                                    for (int m = 1; m < 10; m++) {
                                        if (l == m) continue;
                                        if (is_poss(nx, ny, m) && is_poss(i, j, l) && !domino[l][m]) {
                                            map[nx][ny] = m;
                                            map[i][j] = l;
                                            domino[l][m] = true;
                                            domino[m][l] = true;
                                            solve_puz(count - 1, i);
                                            map[nx][ny] = 0;
                                            map[i][j] = 0;
                                            domino[l][m] = false;
                                            domino[m][l] = false;
                                        }
                                    }
                                }
                            }
                        }
                        if (map[i][j] == 0) {
                            is_poss = false;
                            break;
                        }
                    }
                }
                if (!is_poss) break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[9][9];
            domino = new boolean[10][10];
            print_once = false;
            step++;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int[] cord1 = get_cord(st.nextToken());
                map[cord1[0]][cord1[1]] = num1;

                int num2 = Integer.parseInt(st.nextToken());
                int[] cord2 = get_cord(st.nextToken());
                map[cord2[0]][cord2[1]] = num2;

                domino[num1][num2] = true;
                domino[num2][num1] = true;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 10; i++) {
                int[] cord = get_cord(st.nextToken());
                map[cord[0]][cord[1]] = i;
            }
            int count = 36 - N; // 추가해야 할 도미노의 개수
            solve_puz(count, 0);
        }
        bw.flush();
    }
}

