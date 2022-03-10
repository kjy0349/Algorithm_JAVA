package backjoon;
import java.util.*;

public class Wine_drinking_two_dimension {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] d = new int[N + 1][3];
        int[] capacity = new int[N + 1];
        for (int i = 1;i < N + 1;i++) capacity[i] = scan.nextInt();
        d[1][1] = capacity[1];
        int temp;
        for (int i = 2;i < N + 1;i++) {
            temp = Math.max(d[i - 1][0], d[i - 1][1]);
            d[i][0] = Math.max(temp, d[i - 1][2]);
            d[i][1] = d[i - 1][0] + capacity[i];
            d[i][2] = d[i - 1][1] + capacity[i];
        }
        int max_num = Math.max(d[N][1], d[N][2]);
        System.out.println(Math.max(max_num, d[N][0]));
    }
}
