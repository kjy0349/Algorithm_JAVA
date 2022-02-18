package backjoon;
import java.io.*;
import java.util.ArrayList;
public class Get_answer {
    static ArrayList<Integer> answer = new ArrayList<>();
    static int sign;
    static boolean check(char[][] signs){
        int size = answer.size();

        for (int i = 0;i < size;i++){
            for(int j = size; j < size;j++){

            }
        }
    }
    static void solve(int N, int count, char[][] signs){
        if (count == N){
            int printed_count = 0;
            for (Integer elem : answer){
                if (printed_count < N - 1) System.out.print(elem + " ");
                else System.out.println(elem);
            }
        } else if(signs[count][count] == 0){
            answer.add(0);
            solve(N, count + 1, signs);
            answer.remove(answer.size() - 1);
        } else {
            sign = signs[count][count];
            if (sign == '-') sign = -1;
            else sign = 1;
            for (int i = sign;i > 0 ? i < 10 : i > -10;i += sign){
                if (check(signs)){

                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[][] signs = new char[N][N];
        int st_index = 0;
        for (int i = 0;i < N;i++){
            for(int j = i;j < N;j++){
                signs[i][j] = input.charAt(st_index);
                st_index++;
            }
        }
    }
}
