package backjoon;
import java.io.*;
import java.util.Arrays;
public class Divisor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        int answer = numbers[0] * numbers[N-1];
        System.out.println(answer);
    }
}
