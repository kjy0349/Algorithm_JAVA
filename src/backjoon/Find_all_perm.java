package backjoon;
import java.io.*;
public class Find_all_perm {
    public static boolean find_next_perm(int[] perm){
        int i = perm.length - 1;
        while (i > 0 && perm[i - 1] >= perm[i]) i--;
        if (i == 0) return false;
        else {
            int j = perm.length - 1;
            while (j > i && perm[j] <= perm[i - 1]) j--;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] perm = new int[N];
        for (int i = 0;i < perm.length;i++) perm[i] = i + 1;
        do {
            for (int i = 0;i < perm.length;i++){
                if (i < perm.length - 1) bw.write(perm[i] + " ");
                else bw.write(perm[i] + "\n");
            }
        } while(find_next_perm(perm));
        bw.flush();
    }
}
