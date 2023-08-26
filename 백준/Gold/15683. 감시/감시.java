import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static int[][] map;
	static int section;
	static ArrayList<Cctv> cctvs;
	static int answer;
	static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
	
	static class Cctv {
		int x;
		int y;
		int type;
		Cctv(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	public static int see(Cctv ctv, int dir, int elem, int depth) {
		int x = ctv.x + dx[dir];
		int y = ctv.y + dy[dir];
		int cnt = 0;
		while (isIn(x, y)) {
			if (map[x][y] == 6) break;
			if (elem != 0 && map[x][y] == 0) {
				map[x][y] = elem;
				cnt++;
			} else if (elem == 0 && map[x][y] == depth) {
				map[x][y] = 0;
				cnt++;
			}
			x += dx[dir];
			y += dy[dir];
		}
		return cnt;
	}
	
	public static int shoot(Cctv ctv, int dir, int elem, int depth) { // elem은 감시영역일지, 되돌릴지.
		int type = ctv.type;
		int cnt = 0;
		if (type == 1) {
			cnt += see(ctv, dir, elem, depth);
		} else if (type == 2) {
			if (dir == 0 || dir == 2) {
				cnt += see(ctv, 0, elem, depth);
				cnt += see(ctv, 2, elem, depth);
			} else {
				cnt += see(ctv, 1, elem, depth);
				cnt += see(ctv, 3, elem, depth);
			}
		} else {
			for (int i = 0; i < type - 1; i++) {
				cnt += see(ctv, (dir + i) % dx.length, elem, depth);
			}
		}
		return cnt;
	}
	
	public static void solution(int depth, int subSum) {
		if (depth == cctvs.size()) {
//			int cnt = 0;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) if (map[i][j] == 0) cnt++;
//			}
//			if (cnt < answer) answer = cnt;
			if (section - subSum < answer) {
				answer = section - subSum;
			}
//			for (int[] elem : map) System.out.println(Arrays.toString(elem));
//			System.out.println();
			return ;
		}
		for (int i = 0; i < dx.length; i++) {
			Cctv ctv = cctvs.get(depth);
			int cnt = shoot(ctv, i, 10 + depth, 10 + depth); // 감시구역 늘리기
			solution(depth + 1, subSum + cnt);
			shoot(ctv, i, 0, 10 + depth); // 되돌리기
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<>();
		section = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) { // cctv 위치 저장		
					cctvs.add(new Cctv(i, j, map[i][j]));
				} else if (map[i][j] == 0) section++; // 사각지대 개수
			}
		}
		answer = section;
		solution(0, 0);
		System.out.println(answer);
	}
}