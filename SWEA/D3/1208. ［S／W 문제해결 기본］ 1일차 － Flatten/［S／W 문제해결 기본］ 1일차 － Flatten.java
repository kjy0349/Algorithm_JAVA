import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[100];
		StringBuilder sb;
		for (int test = 0; test < 10; test++) {
			int dumpCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = -1;
			for (int i = 0; i < 100; i++) arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < dumpCount + 1; i++) {
				int maxIdx, max, minIdx, min;
				maxIdx = minIdx = -1;
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int j = 0 ; j < 100; j++) {
					if (arr[j] > max) {
						max = arr[j];
						maxIdx = j;
					}
					if (arr[j] < min) {
						min = arr[j];
						minIdx = j;
					}
				}
				answer = max - min;
				if (answer <= 1) {
					break;
				}
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			sb = new StringBuilder();
			sb.append("#");
			sb.append(test + 1);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n"); 
			bw.write(sb.toString());
		}
		bw.flush();
	}
}