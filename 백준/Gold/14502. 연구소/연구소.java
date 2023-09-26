import java.util.*;

public class Main {
    static ArrayList<Cord> virus;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 , 0};
    static int answer;
    static int init_safe;
    static class Cord {
        int x;
        int y;

        Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int depth) {
        if (depth == 3) {
            int result = init_safe;
            int[][] sub_map = new int[map.length][map[0].length];
            for (int i = 0; i < sub_map.length; i++) sub_map[i] = map[i].clone();
            Queue<Cord> queue = new LinkedList<>(virus);
            while (!queue.isEmpty()) {
                Cord elem = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + elem.x;
                    int ny = dy[i] + elem.y;
                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length
                            && sub_map[nx][ny] == 0) {
                        queue.add(new Cord(nx, ny));
                        sub_map[nx][ny] = 2;
                        result--;
                    }
                }
            }
            if (result > answer) answer = result;
        } else {
            for (int i = x; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        bfs(i, depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();
        map = new int[N][M];
        virus = new ArrayList<>();
        init_safe = 0; // 초기 안전영역의 크기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
                if (map[i][j] == 2) virus.add(new Cord(i ,j));
                else if (map[i][j] == 0) init_safe++;
            }
            scan.nextLine();
        }
        init_safe -= 3; // 벽을 세울것이기 때문에, 최대 벽 개수인 3개를 미리 빼줌(안전영역이 아님)
        answer = 0;
        bfs(0, 0);
        System.out.println(answer);
    }
}
