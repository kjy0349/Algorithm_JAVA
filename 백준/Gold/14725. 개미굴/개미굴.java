import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void printTree(Map<String, Object> map, int depth) throws IOException{
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            for (int i = 0; i < depth; i++) bw.write("--");
            bw.write(entry.getKey());
            bw.newLine();
            printTree((Map<String, Object>)entry.getValue(), depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Object> map = new TreeMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Map<String, Object> start = map;
            for (int j = 0; j < K; j++) {
                String food = st.nextToken();
                if (!start.containsKey(food)) {
                    start.put(food, new TreeMap<>());
                    start = (Map<String, Object>)start.get(food);
                } else {
                    start = (Map<String, Object>) start.get(food);
                }
            }
        }
        printTree(map, 0);
        bw.flush();
    }
}