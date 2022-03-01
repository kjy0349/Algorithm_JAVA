package backjoon;
import java.util.*;
import java.io.*;

public class Purchasing_card {
    static int[] d = new int[1001];
    public static int solve(int N, int i, ArrayList<Integer> P){
        if (N == 1) return P.get(1);
        else if (N == 2) return Math.max(P.get(1) * 2, P.get(2));
        else if(d[N] > 0) return d[N];
        else{
            if (N - i > 0){
                d[N] = solve(N - i, i + 1, P) + solve(i, i, P);
            }
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
        System.out.println(solve(N, 0, P));
    }
}
