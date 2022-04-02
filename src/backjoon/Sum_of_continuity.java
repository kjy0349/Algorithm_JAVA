package backjoon;
import java.io.*;
import java.util.Arrays;

public class Sum_of_continuity {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] number = new int[N + 1];
        int[] de = new int[N + 1];
        int[] ds = new int[N + 1];
        int max_num;
        int sub;
        System.arraycopy(temp, 0, number, 1, N);
        de[1] = number[1];
        for (int i = 2;i < N + 1;i++){
            de[i] = Math.max(de[i - 1] + number[i], number[i]);
        }
        max_num = de[1];
        sub = de[1];
        ds[N] = number[N];
        for (int i = N - 1;i >= 1;i--){
            ds[i] = Math.max(ds[i + 1] + number[i], number[i]);
        }
        for (int i = 1;i < N;i++) {
            sub = Math.max(de[i], de[i - 1] + ds[i + 1]);
            max_num = Math.max(sub, max_num);
        }
        if (N != 1) sub = Math.max(de[N - 1], de[N]);
        max_num = Math.max(max_num, sub);
        System.out.println(max_num);
    }
}