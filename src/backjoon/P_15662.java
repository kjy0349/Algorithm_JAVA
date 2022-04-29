package backjoon;
import java.io.*;
import java.util.StringTokenizer;

public class P_15662 {
    public static int[] check_dir(int[][] gear, int target, int direction) {
        int[] directions = new int[gear.length];
        directions[target - 1] = direction;
        for (int i = target - 1; i < gear.length - 1; i++) {
            int current = gear[i][2];
            int compare = gear[i + 1][6];
            if (current != compare) directions[i + 1] = directions[i] * -1;
            else break;
        }
        for (int i = target - 1; i - 1 >= 0; i--) {
            int current = gear[i][6];
            int compare = gear[i - 1][2];
            if (current != compare) directions[i - 1] = directions[i] * -1;
            else break;
        }
        return directions;
    }
    public static int[] spin(int[] gear, int direction) {
        // direction 1: 시계, -1: 반시계
        int[] new_gear;
        new_gear = gear.clone();
        if (direction == -1) {
            for (int i = 0; i < gear.length - 1; i++) new_gear[i] = gear[i + 1];
            new_gear[gear.length - 1] = gear[0];
        } else if (direction == 1){
            for (int i = 1;i < gear.length;i++) new_gear[i] = gear[i - 1];
            new_gear[0] = gear[gear.length - 1];
        }
        return new_gear;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] gear = new int[T][8];
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) gear[i][j] = input.charAt(j) - '0';
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int[] directions = check_dir(gear, target, direction);
            for (int j = 0;j < directions.length;j++) gear[j] = spin(gear[j], directions[j]);
        }
        int answer = 0;
        for (int i = 0; i < T; i++) if (gear[i][0] == 1) answer++;
        System.out.println(answer);
    }
}
