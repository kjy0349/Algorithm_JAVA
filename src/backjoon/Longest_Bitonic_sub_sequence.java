package backjoon;
import java.io.*;
import java.util.Arrays;

public class Longest_Bitonic_sub_sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] number = new int[N + 1];
        int[] d1 = new int[N + 1]; // i에서 끝나는 가장 긴 증가하는 부분수열
        int[] d2 = new int[N + 1]; // i에서 시작하는 가장 긴 감소하는 부분수열
        int max_len = 0;
        System.arraycopy(temp, 0, number, 1, N);
        for (int i = 1;i < N + 1;i++) {
            d1[i] = 1;
            d2[i] = 1;
        }
        for (int i = 2;i < N + 1;i++){
            max_len = 0;
            for (int j = 1;j < i;j++){
                if (number[i] > number[j] && d1[j] > max_len) max_len = d1[j];
            }
            d1[i] = max_len + 1;
        }
        for (int i = N - 1;i >= 1;i--) {
            max_len = 0;
            for (int j = N; j > i; j--) {
                if (number[j] < number[i] && d2[j] > max_len) max_len = d2[j];
            }
            d2[i] = max_len + 1;
        }
        max_len = 0;
        for (int i = 1;i < N + 1;i++){
            if (d1[i] + d2[i] > max_len) max_len = d1[i] + d2[i];
        }
        System.out.println(max_len - 1);
    }
}
