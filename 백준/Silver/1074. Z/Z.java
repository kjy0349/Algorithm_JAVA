import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int r = inputs[1];
        int c = inputs[2];
        if (N == 1)
            System.out.println(r * 2 + c);
        else {
            int target = 0;
            int[] piece;
            for (int j = N - 1; j >= 0; j--)
            {
                piece = new int[4];
                for (int i = 0;i < 4; i++) piece[i] = i * (1 << (2 * j));
                int row = r / (1 << j);
                int col = c / (1 << j);
                target += piece[row * 2 + col];
                r -= row * (1 << j);
                c -= col * (1 << j);
                if (r <= 1 && c <= 1) {
                    target += r * 2 + c;
                    break;
                }
            }
            System.out.println(target);
        }
    }
}
