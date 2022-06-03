package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2580_2 {
    static int[][] map = new int[9][9];
    static boolean[][] r_check = new boolean[9][9]; // 가로 체크
    static boolean[][] c_check = new boolean[9][9]; // 세로 체크
    static boolean[][] b_check = new boolean[9][9]; // 9 * 9 박스 체크

    public static int[] get_box(int i, int j, int num) {
        int big_x = ((num - 1) / 3) * 3;
        int big_y = ((num - 1) % 3) * 3; // num의 상대
        return new int[]{big_x + (i / 3), big_y + (j / 3)};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    map[i][j] = num;
                    r_check[i][num - 1] = true;
                    c_check[num - 1][j] = true; // 주어진 정보 : i행 j열, num이라는 숫자가 생김.
                    int[] index = get_box(i, j, num);
                    b_check[index[0]][index[1]] = true;
                }
            }
        }
        System.out.println("");
    }
}
