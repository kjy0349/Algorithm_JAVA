package backjoon;
import java.io.*;
import java.util.Arrays;
public class N_and_M_one {
    public static void find_comb(int M, int count, boolean[] visited, int[] nums){
        if (count == M){
            int print_count = 0;
            for (int i = 0;i < nums.length; i++){
                if (print_count < M - 1){
                    System.out.print(nums[i]+ " ");
                    print_count++;
                }
                else System.out.println(nums[i]);
            }
        } else{
            for (int i = 0;i < visited.length;i++){
                if (!visited[i]){
                    visited[i] = true;
                    nums[count] = i + 1;
                    find_comb(M, count + 1, visited, nums);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        boolean[] visited = new boolean[N];
        int[] nums = new int[M];
        for (boolean elem : visited) elem = false;
        find_comb(M, 0, visited, nums);
    }
}
