package backjoon;
import java.util.*;
import java.util.stream.Collectors;

public class N_and_M_perm {
    private final int N;
    private boolean[] visited;
    private int[] output;
    private int[] arr;
    private final int R;
    private final ArrayList<ArrayList<Integer>> possible = new ArrayList<>();
    public N_and_M_perm(int N, int R) {
        this.N = N;
        this.R = R;
        visited = new boolean[N];
        arr = new int[N];
        output = new int[R];
        for(int i=0;i<arr.length; i++) arr[i] = i+1;
    }

    public void perm(int depth){
        if (depth == R){
            possible.add((ArrayList<Integer>) Arrays.stream(output).boxed().collect(Collectors.toList()));
        } else{
            for(int i=0; i<N; i++){
                if (!visited[i]){
                    visited[i] = true;
                    output[depth] = arr[i];
                    perm(depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    public void print_solution(){
        for (ArrayList<Integer> integers : possible) {
            for (int j = 0; j < R; j++) {
                System.out.print(integers.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        N_and_M_perm nm = new N_and_M_perm(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
        nm.perm(0);
        nm.print_solution();
    }
}
