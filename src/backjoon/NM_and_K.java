package backjoon;
import java.io.*;
import java.util.Arrays;

public class NM_and_K {
    static int answer = -2147483648;
    static boolean[][] visited;
    static int[][] numbers;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    static boolean check_adj(int x, int y){
        int px;
        int py;
        for (int i = 0;i < 4;i++){
            px = x + dx[i];
            py = y + dy[i];
            if (px >= 0 && px < visited.length && py >= 0 && py < visited[0].length){
                if (visited[px][py]) return (false);
            }
        }
        return (true);
    }

    static void solve(int count, int ans, int px, int py, int K){
        if (count == K){
            if (ans > answer) answer = ans;
        }
        else{
            for (int x = px;x < visited.length;x++){
                for (int y = (x == px ? py : 0);y < visited[0].length;y++){ // 다음 재귀로 넘어간 후, y는 y + 1부터 시작함.
                                                                            // 해당 삼항연산자를 사용하지 않을 경우 그 다음 줄 부터 계속해서 끝값만 탐색하게 됨
                                                                            // y = visited[0].length 까지 도달한 후, 0으로 초기화되지 않음
                    if (check_adj(x, y)){
                        visited[x][y] = true;
                        solve(count + 1,ans + numbers[x][y], x, y + 1, K);
                        visited[x][y] = false;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int K = inputs[2];
        visited = new boolean[N][M];
        numbers = new int[N][M];
        for (int i = 0;i < N;i++) numbers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve(0, 0, 0, 0, K);
        System.out.println(answer);
    }
}
