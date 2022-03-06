package backjoon;
import java.util.*;

public class Wine_drinking {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] d = new int[N + 1][2];
        int[] capacity = new int[N + 1];
        for (int i = 1;i < N + 1;i++) capacity[i] = scan.nextInt();
        d[1][1] = capacity[1];
        for (int i = 2;i < N + 1;i++) {
            d[i][0] = d[i - 1][1];
            d[i][1] = Math.max(d[i - 2][0] + d[i - 1][0], d[i - 2][1] + d[i - 1][0]);
            d[i][1] = Math.max(d[i][1], d[i - 2][0] + d[i - 1][1]) + capacity[i];
            System.out.println(d[i][0] + " " + d[i][1]);
        }
        System.out.println(d[N][0] + " " + d[N][1]);
    }
}
