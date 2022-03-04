package backjoon;
import java.io.*;
import java.util.*;

public class Longest_increasing_subsequence_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] d = new int[1001];
        int[] b = new int[1001];
        d[0] = 1;
        for (int i = 1;i < N;i++){
            int temp_max = 0;
            int before_index = 0;
            for (int j = 0;j < i;j++){
                if (number[i] > number[j] && temp_max < d[j]) {
                    temp_max = d[j];
                    before_index = j;
                }
            }
            d[i] = temp_max + 1;
            b[i] = before_index;
        }
        int max_num = 0;
        int max_index = 0;
        for (int i = 0;i < N;i++) {
            if (max_num < d[i]) {
                max_num = d[i];
                max_index = i;
            }
        }
        System.out.println(max_num);
        for (int i = max_num;i > 0;i--){
            answer.add(number[max_index]);
            max_index = b[max_index];
        }
        Collections.reverse(answer);
        System.out.print(answer.get(0));
        for (int i = 1;i < answer.size();i++){
            System.out.print(" " + answer.get(i));
        }
    }
}
