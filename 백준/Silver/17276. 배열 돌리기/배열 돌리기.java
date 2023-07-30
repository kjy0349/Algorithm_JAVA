import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] new_arr;
        int[][] arr;
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            new_arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                new_arr[i] = arr[i].clone();
            }
            int dir = d >= 0 ? 1 : -1;
            int count = Math.abs(d / 45);
            for (int cnt = 0; cnt < count; cnt++) {
                if (dir == 1) {
                    for (int i = 0; i < n; i++) {
                        new_arr[i][n / 2] = arr[i][i]; // 주 대각선을 가운데열로
                        new_arr[i][n - i - 1] = arr[i][n / 2]; // 가운데열을 부대각선으로
                        new_arr[n / 2][n - i - 1] = arr[i][n - i - 1]; // 부대각선을 가운데행으로
                        new_arr[i][i] = arr[n / 2][i]; // 가운데 행을 주대각선으로
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        new_arr[i][n - i - 1] = arr[n / 2][n - i - 1]; // 가운데행을 부대각선으로
                        new_arr[n / 2][i] = arr[i][i]; // 주대각선으로 가운데 행으로
                        new_arr[i][n / 2] = arr[i][n - i - 1]; // 부대각선을 가운데열로
                        new_arr[i][i] = arr[i][n / 2];
                    }
                }
                for (int i = 0; i < n; i++) arr[i] = new_arr[i].clone();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) bw.write(new_arr[i][j] + " ");
                bw.newLine();
            }
        }
        bw.flush();
    }
}