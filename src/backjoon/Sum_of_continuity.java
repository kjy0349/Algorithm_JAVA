package backjoon;
import java.io.*;
import java.util.Arrays;

public class Sum_of_continuity {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] number = new int[N + 1];
        System.arraycopy(temp, 0, number, 1, N);

    }
}