package backjoon;
import java.io.*;
public class Sum_of_Divisor2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 1; i <= N; i++){
            answer += i * (N / i);
        }
        System.out.println(answer);
    }
}
