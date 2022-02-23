package backjoon;
import java.io.*;
import java.util.Arrays;

public class Salesman_problem {
    static int[][] W;
    static int least_cost = 2147483467;
    public static boolean find_next_perm(int[] perm){
        int i = perm.length - 1;
        while (i > 0 && perm[i - 1] >= perm[i]) i--;
        if (i == 0) return false;
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
    public static void calculate(int[] possible){
        int answer = 0;
        boolean can_be = true;
        for (int i = 0;i < possible.length - 1;i++){
            if (W[possible[i]][possible[i + 1]] == 0) {
                can_be = false;
                break;
            }
            else answer += W[possible[i]][possible[i + 1]];
        }
        if (W[possible[possible.length - 1]][possible[0]] != 0){
            answer += W[possible[possible.length - 1]][possible[0]];
        } else can_be = false;
        if (can_be && answer < least_cost) least_cost = answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        int[] possible = new int[N];
        for (int i = 0;i < N;i++) possible[i] = i;
        for (int i = 0;i < N;i++) W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        do {
            calculate(possible);
        } while(find_next_perm(possible) && possible[0] == 0);
        System.out.println(least_cost);
    }
}
