import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] farm = new int[50][50];
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) farm[i][j] = line.charAt(j) - '0';
			}
			int i, j;
			int answer = 0;
			for (int row = 0; row < N; row++) {
				int idx = 0;
				i = j = N / 2;
				answer += farm[row][j];
				if (row <= N / 2) {
					while (idx < row) {
						i--;
						j++;
						answer += farm[row][i];
						answer += farm[row][j];
						idx++;
					}					
				} else {
					while (idx < N - row - 1) {
						i--;
						j++;
						answer += farm[row][i];
						answer += farm[row][j];
						idx++;
					}
				}
			}
			sb.append("#");
			sb.append(test);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}