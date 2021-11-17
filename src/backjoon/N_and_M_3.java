package backjoon;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
public class N_and_M_3 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find_possible(int N, int M,int depth, String answer) throws IOException {
        if (depth == M){
            bw.write(answer);
            bw.newLine();
        } else{
            for(int i=0;i<N;i++){
                answer += Integer.toString(i+1);
                find_possible(N, M, depth + 1, answer + " ");
                answer = answer.substring(0, answer.length()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        find_possible(N, M, 0, "");
        bw.flush();
    }
}
