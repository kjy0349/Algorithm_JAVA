import java.io.*;
public class SWEA_1289 {
	static char[] elem;
	static int answer;
	public static void find_sol(int count, int start, char[] target) {
		if (count < answer && target.equals(elem)) {
			answer = count;
		} else {
			for (int i = start; i < elem.length; i++) {
				target[i] = '1';
				find_sol(count + 1, i + 1, target);
				target[i] = '0';
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			answer = Integer.MAX_VALUE;
			elem = br.readLine().toCharArray();
			find_sol(0, 0, new char[] {0, 0, 0, 0});
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
