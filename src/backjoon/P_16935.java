package backjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_16935 {
    public static int[][] cal(int[][] map, int command) {
        int N = map.length;
        int M = map[0].length;
        int[][] n_map;

        if (command == 1 || command == 2 || command == 5 || command == 6){ n_map = new int[N][M];}
        else n_map = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (command == 1) n_map[N - 1 - i][j] = map[i][j];
                else if (command == 2) n_map[i][M - j - 1] = map[i][j];
                else if (command == 3) n_map[j][N - 1 - i] = map[i][j];
                else if (command == 4) n_map[M - 1 - j][i] = map[i][j];
                else if (command == 5) {
                    if (i < N / 2 && j < M / 2) n_map[i][j + M / 2] = map[i][j];
                    if (i < N / 2 && j >= M / 2) n_map[i + N / 2][j] = map[i][j];
                    if (i >= N / 2 && j >= M / 2) n_map[i][j - M / 2] = map[i][j];
                    if (i >= N / 2 && j < M / 2) n_map[i - N / 2][j] = map[i][j];
                } else if (command == 6) {
                    if (i < N / 2 && j < M / 2) n_map[i + N / 2][j] = map[i][j];
                    if (i < N / 2 && j >= M / 2) n_map[i][j - M / 2] = map[i][j];
                    if (i >= N / 2 && j >= M / 2) n_map[i - N / 2][j] = map[i][j];
                    if (i >= N / 2 && j < M / 2) n_map[i][j + M / 2] = map[i][j];
                }
            }
        }
        return n_map;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int R = inputs[2];
        int[][] map = new int[N][M];
        int[][] n_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int command : commands) {
            n_map = cal(map, command);
            map = n_map;
        }
        for (int[] ints : n_map) {
            for (int j = 0; j < n_map[0].length - 1; j++) System.out.print(ints[j] + " ");
            System.out.println(ints[n_map[0].length - 1]);
        }
    }
}
