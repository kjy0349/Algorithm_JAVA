package backjoon;
import java.util.*;
import java.io.*;

public class Purchasing_card {
    static int[] d = new int[1001];
    public static int solve(int N, ArrayList<Integer> P){
        if (N == 0) return 0;
        else if (N == 1) return P.get(1);
        else if(d[N] > 0) return d[N];
        else{
            int temp;
            int temp_max = 0;
            for (int i = 1;i <= N;i++){
                temp = solve(N - i, P) + P.get(i);
                if (temp > temp_max) temp_max = temp;
            }
            d[N] = temp_max;
            return d[N];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> P = new ArrayList<>();
        P.add(0);
        String[] inputs = br.readLine().split(" ");
        for (String elem : inputs) {
            P.add(Integer.parseInt(elem));
        }
        System.out.println(solve(N, P));
    }
}
