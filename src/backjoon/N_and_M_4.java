package backjoon;
import java.io.*;
public class N_and_M_4 {
    public static BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int before = 0;
    public static void find_solution(int[] nums,int N, int M, int depth, String answer) throws IOException {
        if(depth == M){
            ber.write(answer);
            ber.newLine();
        } else{
            for(int i=0;i<N;i++){

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
        find_solution(nums,N,M,0,"");
        ber.flush();
    }
}
