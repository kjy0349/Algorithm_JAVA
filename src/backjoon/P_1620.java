package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class P_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(str, i);
            map2.put(i, str);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int elem = Integer.parseInt(input);
                bw.write(map2.get(elem) + "\n");
            } catch (NumberFormatException e) {
                bw.write(map.get(input) + "\n");
            }
        }
        bw.flush();
    }
}
