package backjoon;
import java.io.*;
import java.util.Arrays;

public class N_and_M_sec {
    public static StringBuilder sb = new StringBuilder();
    public static void find_comb_notdup(int M, int count, int start, boolean[] visited){
        if (count == M){
            int print_count = 0;
            for (int i = 0;i < visited.length;i++){
                if (visited[i] && print_count < M - 1){
                    sb.append(i + 1 + " ");
                    print_count++;
                } else if (visited[i]) System.out.println(i + 1);
            }
        } else {
            for (int i = start;i < visited.length;i++){
                if (!visited[i]){
                    visited[i] = true;
                    find_comb_notdup(M, count + 1, i + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int N = inputs[0];
        int M = inputs[1];
        boolean[] visited = new boolean[N];
        find_comb_notdup(M, 0, 0, visited);
    }
}