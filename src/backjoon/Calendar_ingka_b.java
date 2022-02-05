package backjoon;
import java.util.*;
import java.io.*;

public class Calendar_ingka_b {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String[] line = bf.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2])-1;
            int y = Integer.parseInt(line[3])-1;
            boolean ok = false;
            for (int k=x; k<(n*m); k+=m) {
                if (k%n == y) {
                    System.out.println(k+1);
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println(-1);
            }
        }
    }
}
