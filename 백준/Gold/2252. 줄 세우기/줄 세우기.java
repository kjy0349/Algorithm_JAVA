import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] degrees;
	static ArrayList<ArrayList<Integer>> edges;
	static StringBuilder sb;

	
	public static void solution() {
		boolean[] visited = new boolean[edges.size()];
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				visited[i] = true;
				que.offer(i);
			}
		}
		while (!que.isEmpty()) {
			int vtx = que.poll();
			sb.append(vtx).append(" ");
			ArrayList<Integer> edge = edges.get(vtx);
			for (int i = edge.size() - 1; i >= 0; i--) {
				int target = edge.get(i);
				degrees[target]--;
				if (degrees[target] == 0) {
					visited[target] = true;
					que.offer(target);
				}
				edge.remove(i);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		degrees = new int[N + 1];
		edges = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			edges.add(new ArrayList<>());
		}
		sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges.get(from).add(to);
			degrees[to]++;
		}
		solution();
		System.out.println(sb);
	}
}