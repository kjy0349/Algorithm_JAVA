package backjoon;
import java.io.*;
import java.util.*;

public class start_rink {
    public static ArrayList<Integer> min_possible = new ArrayList<>();
    public static void find_possible(int N, int[][] abilitys, int depth, ArrayList<Integer> start, boolean[] visited){
        if(depth == N/2){
            ArrayList<Integer> link = new ArrayList<>();
            int start_sum = 0;
            int link_sum = 0;
            for(int i=0;i<N;i++){
                if(!start.contains(i+1)){
                    link.add(i+1);
                }
            }
            for(int i=0;i<start.size(); i++){
                for(int j=i+1;j<start.size();j++){
                    start_sum += abilitys[start.get(i) - 1][start.get(j) - 1] + abilitys[start.get(j) - 1][start.get(i) - 1];
                    link_sum += abilitys[link.get(i) - 1][link.get(j) - 1] + abilitys[link.get(j) - 1][link.get(i) - 1];
                }
            }
            min_possible.add(Math.abs(start_sum - link_sum));
        } else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    start.add(i+1);
                    find_possible(N, abilitys,depth + 1, start, visited);
                    start.remove(start.indexOf(i+1));
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] abilitys = new int[N][N];
        ArrayList<Integer> start = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            String[] t_line = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                abilitys[i][j] = Integer.parseInt(t_line[j]);
            }
        }
        find_possible(N, abilitys, 0,start, visited);
        System.out.println(Collections.min(min_possible));
    }

}
