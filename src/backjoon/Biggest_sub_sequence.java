package backjoon;
import java.io.*;
import java.util.Arrays;

public class Biggest_sub_sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[N + 1];
        int[] number = new int[N + 1];
        int max_num = 0;
        System.arraycopy(temp, 0, number, 1, N);
        System.arraycopy(number, 1, d, 1, N);
        for (int i = 1;i < N + 1;i++){
            max_num = 0;
            for (int j = 1;j < i;j++){
                if (number[i] > number[j] && d[j] > max_num) max_num = d[j];
            }
            d[i] = max_num + number[i];
        }
        max_num = 0;
        for (int i = 1;i < N + 1;i++){
            if (max_num < d[i]) max_num = d[i];
        }
        System.out.println(max_num);
    }
}
