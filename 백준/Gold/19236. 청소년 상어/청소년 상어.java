import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int answer;
	static int N = 4;
	
	static class Fish{
		int x;
		int y;
		int dir;
		Fish (int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	private static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= 4 || y >= 4) return false;
		return true;
	}
	
	private static void moveFish(Fish[] fishes, int[][] map) {
		for (int i = 1; i < fishes.length; i++) {
			Fish cur = fishes[i];
			if (cur == null) continue;
			
			int dir = cur.dir;
			do {
				int nx = cur.x + dx[cur.dir];
				int ny = cur.y + dy[cur.dir];
				if (!isIn(nx, ny) || map[nx][ny] == -1) {
					cur.dir = (cur.dir + 1) % dx.length;
					continue;
				}
				
				Fish tmp = fishes[map[nx][ny]];
				if (tmp == null) {// 빈공간
					fishes[i] = new Fish(nx, ny, cur.dir);
				}
				else {
					fishes[map[nx][ny]] = new Fish(cur.x, cur.y, tmp.dir);
					fishes[i] = new Fish(nx, ny, cur.dir);
				}
				
				int ntmp = map[nx][ny];
				map[nx][ny] = i;
				map[cur.x][cur.y] = ntmp;
				break;
			} while (cur.dir != dir);
		}
	}
	
	private static void moveShark(Fish shark, Fish tmpShark, int[][] tmpmap, Fish[] tmpFishes, int subSum) {
		for (int i = 0; i < tmpmap.length; i++) {
			int nx = tmpShark.x + dx[tmpShark.dir] * (i + 1);
			int ny = tmpShark.y + dy[tmpShark.dir] * (i + 1);
			
			if (!isIn(nx, ny)) continue;
			if (tmpmap[nx][ny] == 0) continue;
			
			int tnum = tmpmap[nx][ny];
			Fish target = tmpFishes[tnum];
			
			tmpFishes[tnum] = null;
			tmpShark = new Fish(target.x, target.y, target.dir);
			tmpmap[nx][ny] = -1;
			tmpmap[shark.x][shark.y] = 0;
			
			sharkDo(tmpmap, tmpShark, tmpFishes, subSum + tnum);
			
			tmpmap[shark.x][shark.y] = -1;
			tmpmap[nx][ny] = tnum;
			tmpShark = new Fish(shark.x, shark.y, shark.dir);
			tmpFishes[tnum] = new Fish(target.x, target.y, target.dir);
		}
		if (answer < subSum) answer = subSum;
	}
	
	private static void sharkDo(int[][] map, Fish shark, Fish[] fishes, int subSum) {
		int[][] tmpmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) tmpmap[j] = map[j].clone();
		}
		
		Fish tmpShark = new Fish(shark.x, shark.y, shark.dir);
		Fish[] tmpFishes = new Fish[17];
		for (int i = 1; i < tmpFishes.length; i++) {
			if (fishes[i] == null) continue;
			Fish elem = fishes[i];
			tmpFishes[i] = new Fish(elem.x, elem.y, elem.dir);
		}
		moveFish(tmpFishes, tmpmap);
		moveShark(shark, tmpShark, tmpmap, tmpFishes, subSum);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[4][4];
		Fish[] fishes = new Fish[17];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fishes[num] = new Fish(i, j, dir);
			}
		}
		answer = map[0][0];
		Fish shark = new Fish(0, 0, fishes[map[0][0]].dir); // 상어가 0,0에 들어감, 방향을 가짊
		fishes[map[0][0]] = null;
		map[0][0] = -1; // 기존 물고기 버리고, 상어 넣음
		sharkDo(map, shark, fishes, answer);
		System.out.println(answer);
	}
}