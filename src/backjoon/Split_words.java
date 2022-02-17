package backjoon;
import java.io.*;

public class Split_words{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().strip().split(" ");
        int count = 0;
        for (String word : inputs){
            if (word.length() > 0) count++;
        }
        System.out.println(count);
    }
}
