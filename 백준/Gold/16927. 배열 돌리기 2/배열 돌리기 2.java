import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) array[i][j] = Integer.parseInt(st.nextToken());
        }
        int gr_count = Math.min(N, M) / 2;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int k = 0; k < gr_count; k++) {
            ArrayList<Integer> group = new ArrayList<>();
            for (int j = k;j <= M - 2 - k;j++) group.add(array[k][j]);
            for (int i = k;i <= N - k - 2;i++) group.add(array[i][M - k - 1]);
            for (int j = M - 1 - k;j >= k + 1;j--) group.add(array[N - 1 - k][j]);
            for (int i = N - 1 - k;i >= k + 1;i--) group.add(array[i][k]);
            groups.add(group);
        }
        for (int k = 0; k < gr_count; k++) {
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = R % len;
            for (int j = k;j <= M - 2 - k;j++, index = (index + 1) % len) array[k][j] = group.get(index);
            for (int i = k;i <= N - k - 2;i++, index = (index + 1) % len) array[i][M - k - 1] = group.get(index);
            for (int j = M - 1 - k;j >= k + 1;j--, index = (index + 1) % len) array[N - 1 - k][j] = group.get(index);
            for (int i = N - 1 - k;i >= k + 1;i--, index = (index + 1) % len) array[i][k] = group.get(index);
        }
        for (int[] elem : array) {
            for (int j = 0; j < elem.length - 1; j++) {
                sb.append(elem[j]).append(" ");
            }
            sb.append(elem[elem.length - 1]).append("\n");
        }
        System.out.print(sb);
    }
}