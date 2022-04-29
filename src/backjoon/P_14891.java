package backjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_14891 {
    public static int[] spin(int[] gear, int direction) {
        // 방향이 1이면 시계, -1이면 반시계
        int[] new_gear = gear.clone();
        if (direction == 1) {
            for (int i = 0; i < gear.length - 1; i++) new_gear[i + 1] = gear[i];
            new_gear[0] = gear[gear.length - 1];
        }
        if (direction == -1) {
            for (int i = 1;i < gear.length;i++) new_gear[i - 1] = gear[i];
            new_gear[gear.length - 1] = gear[0];
        }
        return new_gear;
    }
    public static int[] get_dir(int[][] gears, int target, int direction) {
        int[] directions = new int[4];
        int current = target - 1;
        directions[current] = direction;
        for (int i = current; i < 3; i++) {
            if (gears[i][2] != gears[i + 1][6]) directions[i + 1] = directions[i] * -1;
            else break;
        }
        for (int i = current; i - 1 >= 0; i--) {
            if (gears[i][6] != gears[i - 1][2]) directions[i - 1] = directions[i] * -1;
        }
        return directions;
    }

    public static void main(String[] args) throws IOException {
        int[][] gears = new int[4][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0;j < 8;j++) gears[i][j] = input.charAt(j) - '0';
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int[] directions = get_dir(gears, target, direction);
            for (int j = 0;j < 4;j++) gears[j] = spin(gears[j], directions[j]);
        }
        int answer = 0;
        for (int i = 0;i < 4;i++) if (gears[i][0] == 1) answer += Math.pow(2, i);
        System.out.println(answer);
    }
}
