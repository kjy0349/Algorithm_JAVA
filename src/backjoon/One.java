package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class One{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null){
            int N = Integer.parseInt(s);
            int num = 0;
            for(int i = 1;;i++){
                num = ((num % N) * 10 + 1) % N;
                if(num == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}