package backjoon;
import java.io.*;
public class Sum_of_Divisor {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] sum_of_divisors = new long[MAX+1];
        for(int i = 1; i <= MAX; i++){
            for(int j = 1; j * i <= MAX; j++){
                sum_of_divisors[i * j] += i;
            }
        }
        for(int i = 2; i <= MAX; i++){
            sum_of_divisors[i] += sum_of_divisors[i-1];
        }
        int T = Integer.parseInt(br.readLine());
        int N;
        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            bw.write(sum_of_divisors[N] + "\n");
        }
        bw.flush();
    }
}
