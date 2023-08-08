import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int answer = -1;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			int i, j;
			i = 0;
			j = arr.length - 1;
			while (i != j) {
				int sub_sum = arr[i] + arr[j];
				if (sub_sum > M) j--;
				else {
					answer = Math.max(answer, sub_sum);
					i++;
				}
			}
			sb.append("#");
			sb.append(test);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}