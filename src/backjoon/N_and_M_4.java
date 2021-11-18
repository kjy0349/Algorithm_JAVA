package backjoon;
import java.io.*;
public class N_and_M_4 {
    public static BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find_solution(int[] nums, int before,int N, int M, int depth, String answer) throws IOException {
        if(depth == M){
            ber.write(answer);
            ber.newLine();
        } else{
            for(int i=0;i<N;i++){
                if(depth == 0){
                    before = nums[i];
                }
                if(before <= nums[i]){
                    answer += Integer.toString(nums[i]);
                    find_solution(nums,nums[i],N,M,depth+1,answer + " ");
                    answer = answer.substring(0, answer.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = i+1;
        }
        find_solution(nums,0,N,M,0,"");
        ber.flush();
    }
}
