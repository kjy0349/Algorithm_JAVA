package backjoon;
import java.io.*;
import java.util.*;

public class Sum_of_subperm_bit {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        int sub_sum;
        for (int i = 1;i < (1 << N);i++){
            sub_sum = 0;
            for (int k = 0;k < N;k++) {
                if ((i & (1 << k)) != 0) sub_sum += numbers[k];
            }
            if (sub_sum == S) answer++;
        }
        System.out.println(answer);
    }
}
