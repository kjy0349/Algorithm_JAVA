package backjoon;
import java.util.Scanner;

public class Strcat_numbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        int length = 1;
        long    ans = 0;
        for (int start = 1;start <= N;start *= 10, length++){
            int end = start * 10 - 1;
            if (end >= N) end = N;
            ans += (long)(end - start + 1) * length;
        }
        System.out.println(ans);
    }
}
