package backjoon;
import java.io.*;
import java.util.Arrays;

public class Next_permutation {
    public static boolean find_next_perm(int[] perm){
        int i = perm.length - 1;
        while (i > 0 && perm[i - 1] >= perm[i]) i -= 1;
        if (i == 0) return false;
        else {
            int j = perm.length - 1;
            while (j > i && perm[j] <= perm[i - 1]) j -= 1;
            int temp = perm[j];
            perm[j] = perm[i - 1];
            perm[i - 1] = temp;
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
        if (find_next_perm(perm)){
            int printed_count = 0;
            for (int elem : perm){
                if (printed_count < perm.length - 1) System.out.print(elem + " ");
                else System.out.println(elem);
                printed_count++;
            }
        } else System.out.println("-1");
    }
}
