package backjoon;
import java.util.*;
public class N_and_M_2_comb {
    public static void combination(int[] arr, boolean[] visited,int start, int r){
        if(r == 0){
            print(arr, visited);
        } else{
            for(int i=start; i<arr.length; i++) {
                if (!visited[i]) { // 있어도, 없어도 똑같음.
                    visited[i] = true;
                    combination(arr, visited, i + 1, r - 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void print(int[] arr, boolean[] visited){
        for(int i=0; i < arr.length; i++){
            if(visited[i]){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int R = scan.nextInt();
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0;i<arr.length; i++){
            arr[i] = i+1;
        }
        combination(arr, visited,0, R);
    }
}
