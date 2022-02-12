package backjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_and_M_fou {
    static StringBuilder sb = new StringBuilder();
    static void find_comb(int N, int M, int count, int start, int[] arr_output){
        if (count == M){
            int printed_count = 0;
            for (int number : arr_output){
                if (printed_count < M - 1) sb.append(number).append(" ");
                else sb.append(number).append("\n");
                printed_count++;
            }
        }
        else {
            for (int i = start;i < N;i++){
                arr_output[count] = i + 1;
                find_comb(N, M, count + 1, i, arr_output);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr_output = new int[M];
        find_comb(N, M, 0, 0, arr_output);
        System.out.print(sb);
    }
}
