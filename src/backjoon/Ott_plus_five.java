package backjoon;
import java.io.*;
public class Ott_plus_five {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long divisor = 1000000009L;
    static long[][] d = new long[100001][4];
    public static long solve(int N, int number){
        if (N == 1){
            d[N][1] = 1;
            return d[N][number];
        } else if (N == 2){
            d[N][2] = 1;
            return d[N][number];
        } else if (N == 3){
            return 1;
        } else if (N == 4){
            d[N][1] = 2;
            d[N][3] = 1;
            return d[N][number];
        }
        else if (d[N][number] > 0) return d[N][number];
        else {
            if (number == 1 && N - 1 >= 0) d[N][number] = solve(N - 1, 2) + solve(N - 1, 3);
            if (number == 2 && N - 2 >= 0) d[N][number] = solve(N - 2, 1) + solve(N - 2, 3);
            if (number == 3 && N - 3 >= 0) d[N][number] = solve(N - 3, 1) + solve(N - 3, 2);
            d[N][number] %= divisor;
            return d[N][number];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        for (int i = 0;i < T;i++){
            N = Integer.parseInt(br.readLine());
            bw.write((solve(N, 1) + solve(N, 2) + solve(N, 3)) % divisor + "\n");
        }
        bw.flush();
    }
}
