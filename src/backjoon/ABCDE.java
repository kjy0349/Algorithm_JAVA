package backjoon;
import java.util.*;

class Edge {
    int from;
    int to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
public class ABCDE {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        boolean[][] adjacency_array = new boolean[N][N]; // 인접 행렬
        ArrayList<Edge> edges = new ArrayList<>(N); // 간선 리스트
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0;i < N;i++) adjacency_list.add(new ArrayList<>());
        for (int i = 0;i < M;i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            adjacency_array[from][to] = adjacency_array[to][from] = true;
            adjacency_list.get(from).add(to);
            adjacency_list.get(to).add(from);
        }
        M *= 2;
        for (int i = 0;i < M;i++){
            int A = edges.get(i).from;
            int B = edges.get(i).to;
            for (int j = 0;j < M;j++){
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D) continue;
                if (!adjacency_array[B][C]) continue;
                for (int edge : adjacency_list.get(D)) {
                    if (edge == A || edge == B || edge == C || edge == D) continue;
                    System.out.println(1);
                    return ;
                }
            }
        }
        System.out.println(0);
    }
}