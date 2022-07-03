package showmethecode;
import java.io.*;
import java.util.StringTokenizer;

public class A {
    static int[] monsters;
    static boolean[] visited;
    static int[] vil;
    static int answer;
    public static void bfs(int sub_sum, int hp, int damage) {
        if (sub_sum > answer) answer = sub_sum;
        for (int i = 0; i < monsters.length; i++) {
            if (!visited[i] && hp - (damage + monsters[i]) >= 0) {
                visited[i] = true;
                damage += monsters[i];
                bfs(sub_sum + vil[i], hp - damage, damage);
                damage -= monsters[i];
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        monsters = new int[N];
        vil = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) monsters[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) vil[i] = Integer.parseInt(st.nextToken());
        bfs(0, K, 0);
        System.out.println(answer);
    }
}
