package backjoon;
import java.util.*;
import java.io.*;
public class Date_Calculate {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int E;int S; int M;
        E = inputs[0] - 1;
        S = inputs[1] - 1;
        M = inputs[2] - 1;
        for(int i=0;i<=7979;i++){
            if(E == i%15 && S == i%28 && M == i%19){
                System.out.println(i+1);
                break;
            }
        }
    }
}
