package backjoon;
import java.util.Scanner;
public class Easy_stair_number {
    static int mod = 1000000000;
    static int[][] d = new int[101][10];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 1;i < 10;i++) d[1][i] = 1;
        for (int i = 2;i <= N;i++){
            for (int j = 0;j <= 9;j++){
                if (j == 0) d[i][j] = d[i - 1][j + 1];
                else if (j == 9) d[i][j] = d[i - 1][j - 1];
                else d[i][j] = (d[i - 1][j + 1] + d[i - 1][j - 1]) % mod;
            }
        }
        int sum = 0;
        for (int elem : d[N]) sum = (sum + elem) % mod;
        System.out.println(sum);
    }
}
