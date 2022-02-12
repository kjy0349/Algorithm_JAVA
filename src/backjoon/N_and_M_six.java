package backjoon;
import java.io.*;
import java.util.Arrays;
public class N_and_M_six {
    static StringBuilder sb = new StringBuilder();
    static void solve(int M, int count, int start, int[] numbers, int[] arr_output){
        if (M == count){
            int printed_count = 0;
            for (int number : arr_output){
                if (printed_count < M - 1) sb.append(number).append(" ");
                else sb.append(number).append("\n");
                printed_count++;
            }
        } else{
            for (int i = start;i < numbers.length;i++){
                arr_output[count] = numbers[i];
                solve(M, count + 1, i + 1, numbers, arr_output);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] arr_output = new int[M];
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        solve(M, 0, 0, numbers, arr_output);
        System.out.print(sb);
    }
}
