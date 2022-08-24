package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class P_9375_2 {
    static HashMap<String, ArrayList<String>> clothes;
    static ArrayList<String> types;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            clothes = new HashMap<>(); // 타입, 옷 이름들을 갖고 있는 ArrayList
            types = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] inputs = br.readLine().split(" ");
                if (clothes.containsKey(inputs[1])) clothes.get(inputs[1]).add(inputs[0]);
                else {
                    clothes.put(inputs[1], new ArrayList<>());
                    types.add(inputs[1]);
                    clothes.get(inputs[1]).add(inputs[0]);
                }
            }
            int cnt = 1;
            for (String elem : types) cnt *= clothes.get(elem).size() + 1;
            bw.write(cnt - 1 + "\n");
        }
        bw.flush();
    }
}
