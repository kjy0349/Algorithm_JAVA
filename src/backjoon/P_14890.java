package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_14890 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        boolean[][] road = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int diff;
        // 가로 길 체크
        for (int i = 0; i < N; i++) {
            boolean is_poss = true;
            int j = 0;
            while (j < N - 1)
            {
                diff = map[i][j] - map[i][j + 1];
                if (map[i][j] == map[i][j + 1]) j++;
                else if (map[i][j] != map[i][j + 1] && Math.abs(diff) == 1) {
                    // 높 -> 낮
                    if (diff == 1) {
                        for (int k = j + 1; k < L && k < N - 1; k++) {
                            if (map[k] != map[k + 1]) {
                                is_poss = false;
                                break;
                            }
                        }
                    }
                    // 낮 -> 높
                    if (diff == -1){

                    }
                }
                else {
                    is_poss = false;
                    break;
                }
            }
            if (is_poss) answer++;
        }
        // 세로 길 체크
    }
}
