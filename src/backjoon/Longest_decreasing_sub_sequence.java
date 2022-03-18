package backjoon;
import java.io.*;
import java.util.Arrays;

public class Longest_decreasing_sub_sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[N + 1];
        int[] number = new int [N + 1];
        int max_num;
        System.arraycopy(temp, 0, number, 1, N);
        for (int i = 1;i < N + 1;i++) d[i] = 1;
        for (int i = 1;i < N + 1;i++){
            max_num = 0;
            for (int j = 1;j < i;j++){
                if (number[j] > number[i] && d[j] > max_num) max_num = d[j];
            }
            d[i] = max_num + 1;
        }
        max_num = 0;
        for (int elem : d) if (elem > max_num) max_num = elem;
        System.out.println(max_num);
    }
}
