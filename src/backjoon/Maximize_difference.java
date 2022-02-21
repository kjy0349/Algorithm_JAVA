package backjoon;
import java.io.*;
import java.util.Arrays;

public class Maximize_difference {
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

    public static int calculate(int[] numbers){
        int answer = 0;
        for (int i = 0;i < numbers.length - 1;i++) answer += Math.abs(numbers[i] - numbers[i + 1]);
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] perm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(perm);
        int answer = -2147483648;
        do {
            int sub_sum = calculate(perm);
            if (sub_sum > answer) answer = sub_sum;
        } while (find_next_perm(perm));
        System.out.println(answer);
    }
}
