package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {
    static int[][] map;
    static int answer;
    public static void down() {
        for (int i = 0; i < 7; i++) {
            for (int j = 6; j > 0; j--) {
                if (map[j][i] == 0) {
                    map[j][i] = map[j - 1][i];
                    map[j - 1][i] = 0;
                }
            }
        }
    }
    public static boolean tetris() {
        boolean played = false;
        Queue<int[]> poss = new LinkedList<>();
        // 가로 탐색
        for (int i = 0; i < 7; i++) {
            int j = 0;
            while (j < map[0].length) {
                if (map[i][j] > 0) {
                    int size = 0;
                    int k = j;
                    while (k < map[0].length && map[i][k] > 0) {
                        size++;
                        k++;
                    }
                    for (int l = j; l < k; l++) {
                        if (map[i][l] == size) poss.add(new int[]{i, l});
                    }
                    j = k;
                } else j++;
            }
        }
        // 세로 탐색
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (map[j][i] > 0) {
                    int size = 0;
                    int k = j;
                    while (k < map.length && map[k][i] > 0) {
                        size++;
                        k++;
                    }

                    for (int l = j; l < k; l++) {
                        if (map[l][i] == size) poss.add(new int[]{l, i});
                    }
                }
            }
        }
        if (poss.size() > 0) {
            while (!poss.isEmpty()) {
                int[] temp = poss.poll();
                map[temp[0]][temp[1]] = 0;
            }
            down();
            int result = 0;
            for (int k = 0; k < 7; k++) {
                for (int l = 0; l < 7; l++) {
                    if (map[k][l] > 0) result++;
                }
            }
            if (answer > result) answer = result;
            played = true;
        }
        return played;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][][] temp = new int[7][7][7];
        int result = 0;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                int elem = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 7; k++) {
                    temp[k][i][j] = elem;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (temp[0][i][j] > 0) result++;
            }
        }
        int num = Integer.parseInt(br.readLine());
        answer = result + 1;
        for (int i = 0; i < 7; i++) { // 열 선택
            int j = 0;
            map = temp[i]; // 맵 선택
            while (j + 1 < map.length && map[j + 1][i] == 0) j++;
            map[j][i] = num; // 공 착륙
            while (tetris());
        }
        System.out.println(answer);
    }
}
