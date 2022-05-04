package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_14890 {
    public static boolean check_row(int[] map, boolean[] road, int start, int end) {
        if (start == end) {
            if (!road[start]) {
                road[start] = true;
                return true;
            } else return false;
        }
        for (int i = start;i < end;i++) {
            if (map[i] != map[i + 1] || road[i] || road[i + 1]) return false;
        }
        for (int i = start;i <= end;i++) road[i] = true;
        return true;
    }
    public static boolean check_col(int[][] map, boolean[][] road, int j, int start, int end){
        if (start == end) {
            if (!road[start][j]) {
                road[start][j] = true;
                return true;
            } else return false;
        }
        for (int i = start;i < end;i++) {
            if (map[i][j] != map[i + 1][j] || road[i][j] || road[i + 1][j]) return false;
        }
        for (int i = start; i <= end; i++) road[i][j] = true;
        return true;
    }

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
                        if (j + L >= N) {
                            is_poss = false;
                            break;
                        }
                        if (!check_row(map[i], road[i], j + 1, j + L)) {
                            is_poss = false;
                            break;
                        }
                        else {
                            j += L;
                            continue;
                        }
                    }
                    // 낮 -> 높
                    if (diff == -1){
                        if (j - L + 1 < 0) {
                            is_poss = false;
                            break;
                        }
                        if (!check_row(map[i], road[i], j - L + 1, j)) {
                            is_poss = false;
                            break;
                        }
                        else j++;
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
        road = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            boolean is_poss = true;
            int i = 0;
            while (i < N - 1)
            {
                diff = map[i][j] - map[i + 1][j];
                if (map[i][j] == map[i + 1][j]) i++;
                else if (map[i][j] != map[i + 1][j] && Math.abs(diff) == 1) {
                    // 높 -> 낮
                    if (diff == 1) {
                        if (i + L >= N) {
                            is_poss = false;
                            break;
                        }
                        if (!check_col(map, road, j, i + 1, i + L)) {
                            is_poss = false;
                            break;
                        }
                        else {
                            i += L;
                            continue;
                        }
                    }
                    // 낮 -> 높
                    if (diff == -1){
                        if (i - L + 1 < 0) {
                            is_poss = false;
                            break;
                        }
                        if (!check_col(map, road, j, i - L + 1, i)) {
                            is_poss = false;
                            break;
                        }
                        else i++;
                    }
                }
                else {
                    is_poss = false;
                    break;
                }
            }
            if (is_poss) answer++;
        }
        System.out.println(answer);
    }
}
