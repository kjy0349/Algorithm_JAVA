package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Start {
    int x;
    int y;
    Start(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class P_14499 {
    public static int[] roll(int[] dice, int direction) {
        // direction 1: 동, 2: 서, 3: 북, 4: 남
        int[] answer = new int[dice.length];
        answer = dice.clone();
        switch (direction) {
            case 1:
                answer[3] = dice[0];
                answer[0] = dice[1];
                answer[1] = dice[5];
                answer[5] = dice[3];
                break;
            case 2:
                answer[1] = dice[0];
                answer[0] = dice[3];
                answer[3] = dice[5];
                answer[5] = dice[1];
                break;
            case 3:
                answer[2] = dice[0];
                answer[0] = dice[4];
                answer[4] = dice[5];
                answer[5] = dice[2];
                break;
            case 4:
                answer[4] = dice[0];
                answer[5] = dice[4];
                answer[2] = dice[5];
                answer[0] = dice[2];
                break;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Start start = new Start(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dice = new int[6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int command : commands) {
            boolean is_checked = false;
            switch (command) {
                case 1:
                    if (start.y + 1 < M) {
                        dice = roll(dice, command);
                        start.y++;
                        is_checked = true;
                    }
                    break;
                case 2:
                    if (start.y - 1 >= 0) {
                        dice = roll(dice, command);
                        start.y--;
                        is_checked = true;
                    }
                    break;
                case 3:
                    if (start.x - 1 >= 0) {
                        dice = roll(dice, command);
                        start.x--;
                        is_checked = true;
                    }
                    break;
                case 4:
                    if (start.x + 1 < N) {
                        dice = roll(dice, command);
                        start.x++;
                        is_checked = true;
                    }
                    break;
            }
            if (is_checked) {
                if (map[start.x][start.y] == 0) map[start.x][start.y] = dice[5];
                else {
                    dice[5] = map[start.x][start.y];
                    map[start.x][start.y] = 0;
                }
                sb.append(dice[0]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
