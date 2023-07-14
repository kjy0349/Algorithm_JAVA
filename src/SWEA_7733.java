import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class SWEA_7733 {
	static int[][] map;
	static int answer;
	static int sub_sum;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void find_sol(int x, int y, boolean[][] visited, int cnt, int day) {
		boolean chk = false;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length &&
					!visited[nx][ny] && map[nx][ny] > day) {
				find_sol(nx, ny, visited, cnt + 1, day);
				chk = true;
			}
		}
		if (!chk) sub_sum++;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			answer = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int k = 1; k <= 100; k++) {
				sub_sum = 0;
				boolean[][] visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j]) {
							find_sol(i, j, visited, 0, k);					
						}
					}
				}
				if (sub_sum > answer) answer = sub_sum;
			}
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
