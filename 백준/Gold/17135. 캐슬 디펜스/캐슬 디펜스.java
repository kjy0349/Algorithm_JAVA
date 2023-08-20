import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static char[][] input;
    static int D;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Cord target;
    static Queue<Cord> killed;
    static int answer;
    static class Cord {
        int x;
        int y;
        Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void shoot(char elem) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Cord> que = new ArrayDeque<>();
        que.offer(new Cord(map.length - 1, elem));
        target = null;
        while (!que.isEmpty()) {
            Cord bow = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = bow.x + dx[i];
                int ny = bow.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length - 1 && ny < map[0].length
                && !visited[nx][ny] && Math.abs(nx - (map.length - 1)) + Math.abs(ny - elem) <= D) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == '1') { // 적 발견
                        if (target == null) target = new Cord(nx, ny);
                        else {
                            int dist = Math.abs(nx - (map.length - 1)) + Math.abs(ny - elem);
                            int compare = Math.abs(target.x - (map.length - 1)) + Math.abs(target.y - elem);
                            if (ny < target.y && dist <= compare) target = new Cord(nx, ny);
                        }
                    } else {
                        que.offer(new Cord(nx, ny));
                    }
                }
            }
        }
        if (target != null) killed.offer(target);
    }

    public static void tick(char[] choose) {
        int sub_sum = 0;
        for (int i = 0; i < map.length - 1; i++) {
            for (char elem : choose) { // 각 궁수가 누굴 쏠지 정함
                shoot(elem);
            }
            while (!killed.isEmpty()) { // 정한 애들 다 없애기
                Cord target = killed.poll();
                if (map[target.x][target.y] == '1') {
                    sub_sum++;
                }
                map[target.x][target.y] = '0';
            }
            // 다 사라질 친구들 없애기
            for (int j = 0; j < map[0].length; j++) map[map.length - 2][j] = '0';
            for (int j = 0; j < map.length - 2; j++) {
                for (int k = 0; k < map[0].length; k++) {
                    if (map[map.length - 3 - j][k] == '1') {
                        map[map.length - 2 - j][k] = '1';
                        map[map.length - 3 - j][k] = '0';
                    }
                }
            }
//            for (char[] elem : map) System.out.println(Arrays.toString(elem));
//            System.out.println();
        }
        if (sub_sum > answer) answer = sub_sum;
    }
    public static void comb(int start, int depth, char[] choose) {
        if (depth == 3) { // 궁수 자리 완료.
            map = new char[input.length][input[0].length];
            for (int i = 0; i < map.length; i++) map[i] = input[i].clone();
            for (char elem : choose) map[input.length - 1][elem] = '2';
            tick(choose);
            for (char elem : choose) map[input.length - 1][elem] = '0';
            return ;
        }
        for (int i = start; i < input[0].length; i++) {
            choose[depth] = (char)i;
            comb(i + 1, depth + 1, choose);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        input = new char[N + 1][M];
        answer = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) input[i][j] = st.nextToken().charAt(0);
        }
        for (int i = 0; i < M; i++) input[input.length - 1][i] = '0';
        killed = new ArrayDeque<>();
        comb(0, 0, new char[3]);
        System.out.println(answer);
    }
}