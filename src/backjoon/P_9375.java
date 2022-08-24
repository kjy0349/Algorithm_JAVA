package backjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class P_9375 {
    static int answer;
    static HashMap<String, ArrayList<String>> clothes;
    static ArrayList<String> types;

    public static void comb(int start) {
        for (int i = start; i < types.size(); i++) {
            int size = clothes.get(types.get(i)).size();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            answer = 0;
            clothes = new HashMap<>();
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
            comb(0);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
