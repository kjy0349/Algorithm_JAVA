package backjoon;
import java.util.Arrays;
import java.util.Scanner;

public class P_1074 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int r = inputs[1];
        int c = inputs[2];
        int target = 0;
        if (N == 1)
            System.out.println(r * 2 + c);
        else {
            int[] piece = new int[4];
            for (int i = 0; i < 4; i++) piece[i] = (int) Math.pow(4, N - 1) * i;
            int row = r / (1 << (N - 1));
            int col = c / (1 << (N - 1));
            target += piece[(row * 2) + col];
            r -= (1 << N - 1) * row;
            c -= (1 << N - 1) * col;
            target += (r / 2) * (1 << N - 2) * 4;
            target += (c / 2) * 4;
            r -= (r / 2) * 2;
            c -= (c / 2) * 2;
            target += (r * 2) + c;
            System.out.println(target);
        }
    }
}
