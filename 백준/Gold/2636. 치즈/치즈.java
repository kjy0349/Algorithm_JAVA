import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int time;
	static int cheeze;
	static int remain;
	static Queue<Cord> que;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Cord {
		int x;
		int y;
		Cord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= map.length || y >= map[0].length);
	}
	
	public static void solution() {
		Queue<Cord> next = new ArrayDeque<>();
		while (cheeze != 0) {
			remain = cheeze;
			while (!que.isEmpty()) {			
				Cord target = que.poll();
				for (int l = 0; l < dx.length; l++) {
					int nx = target.x + dx[l];
					int ny = target.y + dy[l];
					if (isIn(nx, ny)) {
						if (map[nx][ny] == 0) {
							que.offer(new Cord(nx, ny));
							map[nx][ny] = -1;
						} else if (map[nx][ny] == 1){
							map[nx][ny] = -1;
							next.offer(new Cord(nx, ny));
							cheeze--;
						}
					}
				}
			}
			while (!next.isEmpty()) que.offer(next.poll());
			time++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheeze = 0;
		time = 0;
		remain = 0;
		que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheeze++;
				else {
					if (i == 0 || j == 0 || i == map.length - 1 || j == map[0].length - 1) {						
						que.offer(new Cord(i, j));
						map[i][j] = -1;
					}
				}
			}
		}
		solution();
		System.out.println(time);
		System.out.println(remain);
	}
}