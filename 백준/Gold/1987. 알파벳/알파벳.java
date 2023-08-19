import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    static Set<Character> set;
    public static void dfs(int x, int y, int depth) {
        if (answer < depth) answer = depth;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length
            && !visited[nx][ny] && !set.contains(map[nx][ny])) {
                visited[nx][ny] = true;
                set.add(map[nx][ny]);
                dfs(nx, ny, depth + 1);
                set.remove(map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        answer = -1;
        set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0;j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        visited[0][0] = true;
        set.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(answer);
    }
}