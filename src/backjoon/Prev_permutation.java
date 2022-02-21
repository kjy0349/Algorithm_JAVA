package backjoon;
import java.io.*;
import java.util.Arrays;

public class Prev_permutation {
    public static boolean find_prev_perm(int[] perm){
        int i = perm.length - 1;
        while (i > 0 && perm[i - 1] <= perm[i]) i--;
        if (i == 0) return false;
        else {
            int j = perm.length - 1;
            while (j > i && perm[j] >= perm[i - 1]) j--;
            int temp = perm[i - 1];
            perm[i - 1] = perm[j];
            perm[j] = temp;
            j = perm.length - 1;
            while (i < j){
                temp = perm[i];
                perm[i] = perm[j];
                perm[j] = temp;
                i++;
                j--;
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] perm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (find_prev_perm(perm)){
            int printed_count = 0;
            for (int j : perm) {
                if (printed_count < perm.length - 1) System.out.print(j + " ");
                else System.out.println(j);
                printed_count++;
            }
        } else System.out.println(-1);
    }
}
