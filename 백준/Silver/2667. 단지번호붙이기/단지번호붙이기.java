import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static String[][] arr;
	static boolean[][] visited;
	static int vCount;
	static List<Integer> vSizes;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void find_village(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		visited[x][y] = true;
		que.add(new int[] {x, y});
		int sub_answer = 1;
		while (!que.isEmpty()) {
			int[] elem = que.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = elem[0] + dx[i];
				int ny = elem[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length 
						&& !visited[nx][ny] && arr[nx][ny].equals("1")) {
					visited[nx][ny] = true;
					sub_answer++;
					que.add(new int[] {nx, ny});
				}
			}
		}
		vSizes.add(sub_answer);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		visited = new boolean[N][N];
		vSizes = new ArrayList<>();
		vCount = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].equals("1") && !visited[i][j]) {
					vCount++;
					find_village(i, j);
				}
			}
		}
		Collections.sort(vSizes);
		StringBuilder sb = new StringBuilder();
		sb.append(vCount + "\n");
		for (int elem : vSizes) sb.append(elem + "\n");
		System.out.println(sb);
	}
}