import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static char[][] map;
	static int[] sword;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
	
	public static int go(int[] start, int[] target, int type) { //type 1: 벽, 0: 벽x
		Queue<int[]> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		visited[start[0]][start[1]] = true;
		int dis = 0;
		que.offer(start);
		outLoop:
		while (!que.isEmpty()) {
			int size = que.size();
			dis++;
			for (int k = 0; k < size; k++) {
				int[] elem = que.poll();
				int x = elem[0];
				int y = elem[1];
				for (int i = 0; i < dx.length; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (isIn(nx, ny) && !visited[nx][ny]) {
						if ((type == 1 && map[nx][ny] != '1') || type == 0) {							
							visited[nx][ny] = true;
							if (visited[target[0]][target[1]]) break outLoop;
							que.offer(new int[] {nx, ny});
						}
					}
				}
			}
		}
		if (visited[target[0]][target[1]]) {			
			return dis;
		} else return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		sword = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == '2') {
					sword[0] = i;
					sword[1] = j;
				}
			}
		}
		int swordDis = go(new int[] {0, 0}, sword, 1);	
		int	swordTargetDis = go(sword, new int[] {N - 1, M - 1}, 0);
		int swResult = swordDis + swordTargetDis;
		int normalRescue = go(new int[] {0, 0}, new int[] {N - 1, M - 1}, 1);
		if (swordDis > 0 && swordTargetDis > 0 && swResult > 0 && normalRescue > 0) { // 둘다 가능 할 때
			if (swResult <= T && normalRescue <= T) {
				System.out.println(Math.min(swResult, normalRescue));
			} else if (swResult <= T) {
				System.out.println(swResult);
			} else if (normalRescue <= T) {
				System.out.println(normalRescue);
			} else System.out.println("Fail");
		} else if (swordDis > 0 && swordTargetDis > 0 && swResult > 0) { // 칼 잡고만 가능 할 때
			if (swResult <= T) System.out.println(swResult);
			else System.out.println("Fail");
		} else if (normalRescue > 0) { // 일반적인 경우만 가능 할 때
			if (normalRescue <= T) System.out.println(normalRescue);
			else System.out.println("Fail");
		} else System.out.println("Fail");
	}
}