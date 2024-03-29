package backjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class P_9375 {
    static long answer;
    static HashMap<String, ArrayList<String>> clothes;
    static ArrayList<String> types;

    public static void comb(int start) {
        if (start != types.size()) { // 옷 종류 String들을 갖고 있는 문자열 ArrayList
            for (int i = start; i < types.size(); i++) { // 30
                int size = clothes.get(types.get(i)).size(); // 1
                for (int j = 0; j < size; j++) {
                    answer++;
                    comb(i + 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            answer = 0; // 횟수 세서 반환할 변수
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
            comb(0);
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
