package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class P_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            bw.write(map.get(str) + "\n");
        }
        bw.flush();
    }
}
