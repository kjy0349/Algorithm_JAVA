package backjoon;
import java.io.*;
import java.util.*;

public class Start_link_bitmask {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ability = new int[N][N];
        int least = 2147483647;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> link = new ArrayList<>();
        int start_sum, link_sum;
        for (int i = 0;i < N;i++) ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1;i < (1 << N);i++){
            start.clear();
            link.clear();
            for(int j = 0;j < N;j++){
                if ((i & (1 << j)) != 0) start.add(j);
                else link.add(j);
            }
            if (start.size() == N / 2){ // 찾았을 때
                start_sum = 0;
                link_sum = 0;
                for (int k = 0;k < start.size();k++){
                    for (int l = 0;l < start.size();l++){
                        start_sum += ability[start.get(k)][start.get(l)];
                        link_sum += ability[link.get(k)][link.get(l)];
                    }
                }
                if (Math.abs(start_sum - link_sum) < least) least = Math.abs(start_sum - link_sum);
            }
        }
        System.out.println(least);
    }
}
