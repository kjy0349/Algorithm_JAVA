package backjoon;
import java.util.*;

class Edge {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class ABCDE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        boolean[][] a = new boolean[N][N];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N);
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0;i < N;i++) graph.add(new ArrayList<>());
        for (int i = 0;i < M;i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            a[from][to] = a[to][from] = true;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        M *= 2;
        for (int i = 0;i < M;i++){
            for (int j = 0;j < M;j++){
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D) continue;
                if (!a[B][C]) continue;
                for (int E : graph.get(D)){
                    if (A == E || B == E || C == E || D == E) continue;
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}
