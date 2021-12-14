package backjoon;
import java.io.*;
import java.util.Arrays;
public class GCD_GCM {
    public static int GCD(int a, int b){
        if(b == 0) return a;
        else return GCD(b, a%b);
    }
    public static int GCM(int a, int b){
        int gcd = GCD(a, b);
        return (a*b)/gcd;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A;
        int B;
        if(inputs[0] > inputs[1]){
            A = inputs[0];
            B = inputs[1];
        }
        else{
            A = inputs[1];
            B = inputs[0];
        }
        System.out.println(GCD(A, B) + "\n" + GCM(A, B));
    }
}
