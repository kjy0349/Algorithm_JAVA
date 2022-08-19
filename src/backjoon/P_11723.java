package backjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P_11723 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String cmd = inputs[0];
            int elem = 0;
            if (inputs.length > 1) {
                elem = Integer.parseInt(inputs[1]);
            }
            switch (cmd) {
                case "add":
                    set.add(elem);
                    break;
                case "remove":
                    set.remove(elem);
                    break;
                case "check":
                    if (set.contains(elem)) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "toggle":
                    if (set.contains(elem)) set.remove(elem);
                    else set.add(elem);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        bw.flush();
    }
}
