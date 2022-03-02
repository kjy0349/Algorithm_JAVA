package backjoon;
import java.io.*;
public class Ott_plus_five_bu {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int mod = 1000000009;
    static int[][] d = new int[100001][4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        d[1][1] = d[2][2] = d[3][3] = d[3][2] = d[3][1] = d[4][3] = 1;
        d[4][1] = 2;
        for (int j = 5;j <= 100000;j++){
            d[j][1] = (d[j - 1][2] + d[j - 1][3]) % mod;
            d[j][2] = (d[j - 2][1] + d[j - 2][3]) % mod;
            d[j][3] = (d[j - 3][1] + d[j - 3][2]) % mod;
        }
        for (int i = 0;i < T;i++){
            N = Integer.parseInt(br.readLine());
            bw.write((((d[N][1] + d[N][2]) % mod) + d[N][3]) % mod + "\n");
        }
        bw.flush();
    }
}
