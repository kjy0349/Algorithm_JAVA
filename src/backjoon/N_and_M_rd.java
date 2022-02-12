package backjoon;
import java.io.*;
import java.util.Arrays;

public class N_and_M_rd {
    public static StringBuilder bw = new StringBuilder();
    public static void find_perm_dup(int M, int count, int[] print_numbers, int[] arr_output){
        if (count == M){
            int printed_count = 0;
            for (int number : arr_output) {
                if (printed_count < M - 1) bw.append(number).append(" ");
                else bw.append(number).append("\n");
                printed_count++;
            }
        } else{
            for (int print_number : print_numbers) {
                arr_output[count] = print_number;
                find_perm_dup(M, count + 1, print_numbers, arr_output);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int[] print_numbers = new int[N];
        int[] arr_output = new int [M];
        for (int i = 0; i < print_numbers.length; i++) print_numbers[i] = i + 1;
        find_perm_dup(M, 0, print_numbers, arr_output);
        System.out.print(bw);
    }
}
