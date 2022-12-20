package backjoon;
import showmethecode.A;

import java.util.*;

public class P_14502 {
    static class Cord {
        int x;
        int y;
        Cord (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[][] t_map;
    static ArrayList<Cord> virus_cord;
    static Queue<Cord> t_queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;
    static int init_spaces;
    public static void recursion(int start_x, int start_y, int depth) {
        if (depth == 3) {
            int result = init_spaces;
            t_map = new int[N][M];
            for (int i = 0; i < N; i++) t_map[i] = map[i].clone();
            t_queue = new LinkedList<>();
            t_queue.addAll(virus_cord);
            while (!t_queue.isEmpty()) {
                Cord target = t_queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = target.x + dx[i];
                    int ny = target.y + dy[i];
                    if (nx < N && nx >= 0 && ny < M && ny >= 0 && t_map[nx][ny] == 0) {
                        t_map[nx][ny] = 2;
                        result--;
                        t_queue.add(new Cord(nx, ny));
                    }
                }
            }
            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(t_map[i]));
            System.out.println(result + "\n\n");
            if (result > answer) answer = result;
        } else {
            for (int i = start_x; i < N; i++) {
                for (int j = start_y; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        if (j + 1 == M)
                            recursion(i + 1, 0, depth + 1);
                        else
                            recursion(i, j + 1, depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        map = new int[N][M];
        answer = 0;
        t_queue = new LinkedList<>();
        virus_cord = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
                if (map[i][j] == 0) init_spaces++;
                else if (map[i][j] == 2) virus_cord.add(new Cord(i, j));
            }
            scan.nextLine();
        }
        init_spaces -= 3;
        recursion(0, 0, 0);
        System.out.println(answer);
    }
}
