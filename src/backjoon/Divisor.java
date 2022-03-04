package backjoon;
import java.util.Scanner;
import java.util.Arrays;
public class Divisor {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] numbers = new int[N];
        for (int i = 0;i < N; i++){
            numbers[i] = scan.nextInt();
        }
        Arrays.sort(numbers);
        int answer = numbers[0] * numbers[N-1];
        System.out.println(answer);
    }
}