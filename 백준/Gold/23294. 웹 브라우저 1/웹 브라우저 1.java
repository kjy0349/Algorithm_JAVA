import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Page {
        int num;
        int cash;

        public Page(int num, int cash) {
            this.num = num;
            this.cash = cash;
        }

        @Override
        public String toString() {
            return "Page{" +
                    "num=" + num +
                    ", cash=" + cash +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Page> frontDeque = new ArrayDeque<>();
        Deque<Page> backDeque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Page cur = null;
        int nowCash = 0;
        st = new StringTokenizer(br.readLine());
        int[] pages = new int[N + 1];
        for (int i = 1; i < pages.length; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'A') {
                int num = Integer.parseInt(st.nextToken());
                Page tmp;
                while (!frontDeque.isEmpty()) { // 앞으로가기 다 비우기.
                    tmp = frontDeque.poll();
                    nowCash -= tmp.cash;
                }
                if (cur != null) { // 처음 접속할 때가 아닌 경우
                    backDeque.offerFirst(cur);
                }
                cur = new Page(num, pages[num]);
                nowCash += pages[num];
                if (nowCash > C) {
                    while (nowCash > C) {
                        tmp = backDeque.pollLast();
                        nowCash -= tmp.cash;
                    }
                }
            } else if (command == 'B') {
                if (!backDeque.isEmpty()) {
                    Page tmp = backDeque.poll();
                    frontDeque.offerFirst(cur);
                    cur = new Page(tmp.num, tmp.cash);
                }
            } else if (command == 'F') {
                if (!frontDeque.isEmpty()) {
                    Page tmp = frontDeque.poll();
                    backDeque.offerFirst(cur);
                    cur = new Page(tmp.num, tmp.cash);
                }
            } else if (command == 'C') {
                if (!backDeque.isEmpty()) {
                    Deque<Page> tmpDeque = new ArrayDeque<>();
                    int before = -1;
                    while (!backDeque.isEmpty()) {
                        Page tmp = backDeque.poll();
                        if (tmp.num == before) {
                            nowCash -= tmp.cash;
                        } else tmpDeque.offerLast(tmp);
                        before = tmp.num;
                    }
                    backDeque = tmpDeque;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cur.num).append("\n");
        if (!backDeque.isEmpty()) {
            while (!backDeque.isEmpty()) {
                Page tmp = backDeque.poll();
                sb.append(tmp.num).append(" ");
            }
            sb.append("\n");
        } else sb.append("-1\n");
        if (!frontDeque.isEmpty()) {
            while (!frontDeque.isEmpty()) {
                Page tmp = frontDeque.poll();
                sb.append(tmp.num).append(" ");
            }
            sb.append("\n");
        } else sb.append("-1\n");
        System.out.print(sb);
    }
}