import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static String[][] map;
	static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
	static int count;
	static int N;
	
	public static boolean chkDir(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny].equals("*")) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		map = new String[300][300];
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[N][N];
			StringTokenizer st;
			count = 0; //숫자 칸 총 개수
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j];
					if (map[i][j].equals(".")) count++;
				}
			}
			int sub_count = 0; //숫자 칸 인덱스
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && chkDir(i, j) && map[i][j].equals(".")) {
						Queue<int[]> que = new ArrayDeque<>();
						visited[i][j] = true;
						sub_count++;
						que.add(new int[] {i, j});
						while (!que.isEmpty()) {
							int[] elem = que.poll();
							for (int k = 0; k < dx.length; k++) {
								int nx = elem[0] + dx[k];
								int ny = elem[1] + dy[k];
								if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny].equals(".") && !visited[nx][ny]) {
									visited[nx][ny] = true;
									if (chkDir(nx, ny)) {
										que.add(new int[] {nx, ny});
										visited[nx][ny] = true;
										sub_count++;
										answer++;
									}
									sub_count++;
								}
							}							
						}
						answer++;
					}
				}
			}

			sb.append("#");
			sb.append(test);
			sb.append(" ");
			sb.append(answer + count - sub_count);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}