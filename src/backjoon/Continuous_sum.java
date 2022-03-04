package backjoon;
import java.io.*;
import java.util.Arrays;

public class Continuous_sum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[100001];
        d[0] = number[0];
        int max_num = d[0];
        for (int i = 1;i < N;i++){
            d[i] = Math.max(d[i - 1] + number[i], number[i]);
            if (d[i] > max_num) max_num = d[i];
        }
        System.out.println(max_num);
    }
}
