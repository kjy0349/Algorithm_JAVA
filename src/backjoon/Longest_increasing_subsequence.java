package backjoon;
import java.io.*;
import java.util.*;

public class Longest_increasing_subsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[1001];
        d[0] = 1;
        for (int i = 1;i < N;i++){
            int temp_max = 0;
            for (int j = 0;j < i;j++){
                if (number[i] > number[j] && temp_max < d[j]) temp_max = d[j];
            }
            d[i] = temp_max + 1;
        }
        int max_num = 0;
        for (int elem : d) if (max_num < elem) max_num = elem;
        System.out.println(max_num);
    }
}
