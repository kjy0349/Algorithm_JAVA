package backjoon;
import java.io.*;
import java.util.*;

public class Start_rink {
    static int[][] ability;
    static ArrayList<Integer> first = new ArrayList<>();
    static ArrayList<Integer> second = new ArrayList<>();
    static int diff = 2147483647;
    static void solve(int N, int count){
        if (count == N){
            int first_sum = 0;
            int second_sum = 0;
            if (N / 2 == first.size() && N / 2 == second.size()){
                for(int i = 0;i < N / 2;i++){
                    for (int j = 0;j < N / 2;j++){
                        if (i == j) continue;
                        first_sum += ability[first.get(i)][first.get(j)];
                        second_sum += ability[second.get(i)][second.get(j)];
                    }
                }
                if (Math.abs(first_sum - second_sum) < diff) diff = Math.abs(first_sum - second_sum);
            }
        } else{
            first.add(count);
            solve(N, count + 1);
            first.remove(first.size() - 1);
            second.add(count);
            solve(N, count + 1);
            second.remove(second.size() - 1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        for (int i = 0;i < N;i++) ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve(N, 0);
        System.out.println(diff);
    }
}
