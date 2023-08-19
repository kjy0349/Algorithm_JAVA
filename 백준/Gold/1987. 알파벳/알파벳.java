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
    static boolean[] alphabets;
    public static void dfs(int x, int y, int depth) {
        if (answer < depth) answer = depth;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length
            && !visited[nx][ny] && !alphabets[map[nx][ny] - 'A']) {
                visited[nx][ny] = true;
                alphabets[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, depth + 1);
                alphabets[map[nx][ny] - 'A'] = false;
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
        alphabets = new boolean[26];
        answer = -1;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        visited[0][0] = true;
        alphabets[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }
}