package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class start_rink {
    public static int min = 101;
    public static ArrayList<>
    public static void find_possible(int N, int depth, int answer, boolean[] visited){
        if(depth == N/2){

        } else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i] = false;
                }
            }
        }
    }
    public static void get_min(int[][] abilitys){

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] abilitys = new int[N][N];
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            String[] t_line = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                abilitys[i][j] = Integer.parseInt(t_line[j]);
            }
        }
        find_possible(N, 0,0, visited);
    }

}
