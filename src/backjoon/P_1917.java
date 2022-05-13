package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P_1917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        for (int i = 0; i < 3; i++) {
            int[][] map = new int[6][6];
            StringTokenizer st;
            for (int j = 0; j < 6; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 6; k++) map[j][k] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> adj_cnt = new ArrayList<>();
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    if (map[x][y] == 1) {
                        int temp = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < 6 && ny < 6 && map[nx][ny] == 1) temp++;
                        }
                        adj_cnt.add(temp);
                    }
                }
            }
            boolean is_poss = false;

            if (is_poss) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }
        bw.flush();
    }
}
