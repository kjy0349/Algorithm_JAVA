import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        /*
        쓸모 없는 것들
        A앞에 있는 B
        B앞에 있는 C

        라고 말할 수도 있지만, 가장 많이 뽑으려면
        1. A와 짝지은 B는, 최대한 뒤에 C가 없는 B를 선택한다.
        2. C와 짝지은 B는, 앞에 A가 없는 B를 선택한다. 최대한.
        AABB
        ABAB
        BBCC
        BCBC

        B AABB C ans : 3


        A BC B/ B A C B/ AB B

        ABABABB
        */
        int answer = 0;
        /* 최악일 때 O(n^2). 여기서는 근데 B만 볼거니까 따로 A를 넣어 줄 필요가 있나?
           넣어 줄 필요가 있다. 남은 A와 B의 순서를 유지해야 해.

           1. A나 B가 나오면 그냥 넣는다.
           2. C가 나오면, 먼저 들어온 B를 찾아 제거하고 답을 1 늘린다.
           2-1. 먼저 들어온 B를 선택해야, 남은 B들이 A 뒤에 있을 확률이 높아지므로 가장 낮은 가치인 먼저 들어온 B를 버린다.
        */
        Queue<Integer> bIdx = new ArrayDeque<>();
        boolean[] visited = new boolean[line.length];
        for (int i = 0; i < line.length; i++) {
            char elem = line[i];
            if (elem == 'B') bIdx.offer(i);
            else if (elem == 'C'){ // C
                if (!bIdx.isEmpty()) {
                    answer++;
                    visited[bIdx.poll()] = true;
                }
            }
        }
        // O(n)
        int Acnt = 0;
        for (int i = 0; i < line.length; i++) {
            char elem = line[i];
            if (elem == 'B' && !visited[i]) {
                if (Acnt > 0) {
                    Acnt--;
                    answer++;
                }
            } else if (elem == 'A') Acnt++;
        }
        System.out.println(answer);
    }
}