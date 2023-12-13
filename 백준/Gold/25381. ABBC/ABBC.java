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
        결론
        1. B나 C가 들어오면 그냥 넣는다.
        1-1. A가 들어오면
        */
        int answer = 0;
        Queue<Character> que = new ArrayDeque<>();
        int Acnt = 0;
        for (int i = 0; i < line.length; i++) {
            char elem = line[i];
            if (elem == 'A' || elem == 'B') que.offer(elem);
            else { // C
                Acnt = 0;
                while (!que.isEmpty()) {
                    char target = que.poll();
                    if (target == 'B') {
                        answer++;
                        break;
                    } else Acnt++;
                }
                if (Acnt > 0) {
                    Queue<Character> tmp = new ArrayDeque<>();
                    for (int j = 0; j < Acnt; j++) tmp.offer('A');
                    tmp.addAll(que);
                    que = tmp;
                }
            }
        }
        ArrayList<Character> arr = new ArrayList<>(que);
        Acnt = 0;
        for (char elem : arr) {
            if (elem == 'B') {
                if (Acnt > 0) {
                    Acnt--;
                    answer++;
                }
            } else Acnt++;
        }
        System.out.println(answer);
    }
}