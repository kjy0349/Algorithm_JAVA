package backjoon;

import java.io.*;
import java.util.*;

public class P_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        Set<String> set = new HashSet<>();
        Set<String> set1 = new TreeSet<>();
        int answer = 0;
        for (int i = 0; i < N; i++) set.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                answer++;
                set1.add(str);
            }
        }
        bw.write(answer + "\n");
        for (String elem : set1) bw.write(elem + "\n");
        bw.flush();
    }
}
