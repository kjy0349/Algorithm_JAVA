package backjoon;
import java.io.*;
public class Get_answer_no {
    static int[] answer;
    static boolean check(int count, int[][] signs){
        int sub_sum = 0;
        for (int i = count;i >= 0;i--){
            sub_sum += answer[i];
            if (signs[i][count] == 0 && sub_sum != 0) return false;
            else if (signs[i][count] == -1 && sub_sum >= 0) return false;
            else if (signs[i][count] == 1 && sub_sum <= 0) return false;
        }
        return true;
    }

    static boolean solve(int N, int count, int[][] signs){
        if (count == N) return true;
        if(signs[count][count] == 0){
            answer[count] = 0;
            return (check(count, signs) && solve(N, count + 1, signs));
        }
        for (int i = 1;i <= 10;i++){
            answer[count] = signs[count][count] * i;
            if (check(count, signs) && solve(N, count + 1, signs)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[][] signs = new int[N][N];
        int st_index = 0;
        for (int i = 0;i < N;i++){
            for(int j = i;j < N;j++){
                if (input.charAt(st_index) == '+') signs[i][j] = 1;
                if (input.charAt(st_index) == '-') signs[i][j] = -1;
                if (input.charAt(st_index) == '0') signs[i][j] = 0;
                st_index++;
            }
        }
        answer = new int[N];
        solve(N, 0, signs);
        int printed_count = 0;
        for(int elem : answer){
            if (printed_count < N - 1) System.out.print(elem + " ");
            else System.out.println(elem);
            printed_count++;
        }
        System.out.println();
    }
}