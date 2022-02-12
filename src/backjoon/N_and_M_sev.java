package backjoon;
import java.util.Arrays;
import java.io.*;

public class N_and_M_sev {
    static StringBuilder sb = new StringBuilder();
    static void solve(int M, int count, int[] numbers, int[] arr_output){
        if (count == M){
            int printed_count = 0;
            for(int number : arr_output){
                if (printed_count < M - 1) sb.append(number).append(" ");
                else sb.append(number).append("\n");
                printed_count++;
            }
        } else{
            for(int number : numbers){
                arr_output[count] = number;
                solve(M, count + 1, numbers, arr_output);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr_output = new int[M];
        Arrays.sort(numbers);
        solve(M, 0, numbers, arr_output);
        System.out.print(sb);
    }
}
