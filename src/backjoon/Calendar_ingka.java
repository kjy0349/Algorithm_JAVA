package backjoon;
import java.io.*;
import java.util.Arrays;

public class Calendar_ingka {
    public static void main(String[] args) throws IOException {
        int T;
        int[] inputs;
        int M, N, x, y;
        boolean complete;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = inputs[0];
            N = inputs[1];
            x = inputs[2] - 1;
            y = inputs[3] - 1;
            complete = false;
            for (int j = x; j <= M * N;j += M){
                if (j % N == y){
                    System.out.println(j + 1);
                    complete = true;
                    break ;
                }
            }
            if (!complete)
                System.out.println(-1);
        }
    }
}