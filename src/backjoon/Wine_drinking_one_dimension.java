package backjoon;
import java.util.Scanner;
public class Wine_drinking_one_dimension {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] d = new int[N + 1];
        int[] capacity = new int[N + 1];
        for (int i = 1;i < N + 1;i++) capacity[i] = scan.nextInt();
        d[1] = capacity[1];
        d[2] = capacity[1] + capacity[2];
        d[3] = Math.max(capacity[1] + capacity[2], capacity[2]);
        for (int i = 4;i < N + 1;i++) {
            d[i] = d[i - 1];
            if (d[i] < d[i - 2] + capacity[i])
                d[i] = d[i - 2] + capacity[i];
            if (d[i] < d[i - 3] + capacity[i] + capacity[i - 1])
                d[i] = d[i - 3] + capacity[i] + capacity[i - 1];
        }
        System.out.println(d[N]);
    }
}
