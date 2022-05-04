import java.io.*;
import java.util.Arrays;

public class B_test {

    static int n, l;
    static int[][] map;
    static boolean[][] ramp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = info[0];
        l = info[1];
        ramp = new boolean[n][n];
        map = new int[n][n];
        for (int i = 0 ; i < n; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bw.write(Integer.toString(construction()));
        bw.flush();
    }

    public static int construction() {
        int cnt = 0;
        int idx;

        for (int i = 0 ; i < n; i++) {
            idx = 0;
            boolean flag = true;
            //세로
            while (idx < n - 1) {
                if (map[idx][i] == map[idx + 1][i]) idx++;
                // 높 -> 낮
                else if (map[idx][i] - map[idx + 1][i] == 1) {
                    if (idx + l >= n) {
                        flag = false;
                        break;
                    }
                    if (idx + 1 == idx + l){
                        if (ramp[idx + 1][i]) {
                            flag = false;
                            break;
                        }
                        else ramp[idx + 1][i] = true;
                    }
                    for (int j = idx + 1;j < idx + l; j++) {
                        if (map[j + 1][i] != map[j][i] || ramp[j + 1][i] || ramp[j][i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = idx + 1;j <= idx + l;j++) ramp[j][i] = true;
                        idx += l;
                    } else break;
                } // 낮 -> 높
                else if (map[idx][i] - map[idx + 1][i] == -1) {
                    if (idx + 1 - l < 0) {
                        flag = false;
                        break;
                    }
                    if (idx == idx + 1 - l){
                        if (ramp[idx][i]) {
                            flag = false;
                            break;
                        }
                        else ramp[idx][i] = true;
                    }
                    for (int j = idx; j > idx + 1 - l; j--) {
                        if (map[j][i] != map[j - 1][i] || ramp[j - 1][i] || ramp[j][i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = idx;j >= idx + 1 - l;j--) ramp[j][i] = true;
                        idx++;
                    } else break;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        ramp = new boolean[n][n];
        for (int i = 0 ; i < n; i++) {
            idx = 0;
            boolean flag = true;
            //가로
            while (idx < n - 1) {
                if (map[i][idx] == map[i][idx + 1]) idx++;
                    // 높 -> 낮
                else if (map[i][idx] - map[i][idx + 1] == 1) {
                    if (idx + l >= n) {
                        flag = false;
                        break;
                    }
                    if (idx + 1 == idx + l){
                        if (ramp[i][idx + 1]) {
                            flag = false;
                            break;
                        }
                        else ramp[i][idx + 1] = true;
                    }
                    for (int j = idx + 1;j < idx + l; j++) {
                        if (map[i][j + 1] != map[i][j] || ramp[i][j] || ramp[i][j + 1]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = idx + 1;j <= idx + l;j++) ramp[i][j] = true;
                        idx += l;
                    } else break;
                } // 낮 -> 높
                else if (map[i][idx] - map[i][idx + 1] == -1) {
                    if (idx + 1 - l < 0) {
                        flag = false;
                        break;
                    }
                    if (idx == idx + 1 - l){
                        if (ramp[i][idx]) {
                            flag = false;
                            break;
                        }
                        else ramp[i][idx] = true;
                    }
                    for (int j = idx; j > idx + 1 - l; j--) {
                        if (map[i][j] != map[i][j - 1] || ramp[i][j] || ramp[i][j - 1]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = idx;j >= idx + 1 - l;j--) ramp[i][j] = true;
                        idx++;
                    } else break;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
