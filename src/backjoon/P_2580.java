package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_2580 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> check = new ArrayList<>();
    static int[][] map = new int[9][9];
    public static void find(int N, int count, int sx) throws IOException{
        if (count == N) {
            for (int[] ints : map) {
                bw.write(Integer.toString(ints[0]));
                for (int j = 1; j < map[0].length; j++) bw.write(" " + ints[j]);
                bw.write("\n");
            }
            bw.flush();
            System.exit(0);
        } else {
            for (int i = sx; i < 9; i++) {
                boolean quit = false;
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 0) {
                        for (int k = 1; k < 10; k++) {
                            boolean is_poss = true;
                            check.clear();
                            for (int x = 0; x < 9; x++) check.add(map[x][j]);
                            if (check.contains(k)) is_poss = false;
                            if (is_poss) {
                                check.clear();
                                for (int y = 0; y < 9; y++) check.add(map[i][y]);
                                if (check.contains(k)) is_poss = false;
                            }
                            if (is_poss) {
                                check.clear();
                                int nx = (i / 3) * 3;
                                int ny = (j / 3) * 3;
                                for (int x = nx; x < nx + 3; x++) {
                                    for (int y = ny; y < ny + 3; y++) check.add(map[x][y]);
                                }
                                if (check.contains(k)) is_poss = false;
                            }
                            if (is_poss) {
                                map[i][j] = k;
                                find(N, count + 1, i);
                                map[i][j] = 0;
                            }
                        }
                    }
                    if (map[i][j] == 0) {
                        quit = true;
                        break;
                    }
                }
                if (quit) break; // 빼먹었던 부분
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0;j < 9;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) N++;
            }
        }
        find(N, 0, 0);
    }
}

//0 0 0 0 0 0 0 0 9
//        0 0 0 0 0 0 0 0 8
//        0 0 0 0 0 0 0 0 7
//        0 0 0 0 0 0 0 0 6
//        0 0 0 0 0 0 0 0 5
//        0 0 0 0 0 0 0 0 4
//        0 0 0 0 0 0 0 0 3
//        0 0 0 0 0 0 0 0 2
//        0 0 0 0 0 0 0 0 1
//0 0 0 0 0 0 0 0 0
//        7 8 2 1 3 5 6 4 9
//        4 6 9 2 7 8 1 3 5
//        3 2 1 5 4 6 8 9 7
//        0 0 0 0 0 0 0 0 0
//        5 9 6 8 2 7 4 1 3
//        9 1 7 6 5 2 3 8 4
//        6 4 3 7 8 1 9 5 2
//        0 0 0 0 0 0 0 0 0
