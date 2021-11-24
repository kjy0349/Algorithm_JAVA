package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class password_making {
    public static BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find_password(ArrayList<String> cons, String[] alphabets,int start, int L, int C, String answer, int con_count) throws IOException{
        if(C == 0){
            int other_count = answer.length() - con_count;
            if(con_count >= 1 && other_count >= 2){
                ber.write(answer);
                ber.newLine();
            }
        } else{
            for(int i = start;i < L;i++){
                answer += alphabets[i];
                if (cons.contains(alphabets[i])){
                    con_count += 1;
                }
                find_password(cons, alphabets, i+1, L, C - 1, answer, con_count);
                if (cons.contains(alphabets[i])){
                    con_count -= 1;
                }
                answer = answer.substring(0, answer.length() - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> con = new ArrayList<>(){
            {
                add("a");
                add("e");
                add("i");
                add("o");
                add("u");
            }
        };
        String[] inputs = br.readLine().split(" ");
        int L = Integer.parseInt(inputs[1]);
        int C = Integer.parseInt(inputs[0]);
        String[] alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);
        find_password(con, alphabets, 0, L, C,  "", 0);
        ber.flush();
    }
}
