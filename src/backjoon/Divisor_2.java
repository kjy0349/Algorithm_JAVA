package backjoon;
import java.util.*;
import java.io.*;
public class Divisor_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max_num = 0;
        int min_num = 10000001;
        for(int num : numbers) if(max_num < num) max_num = num;
        for(int num : numbers) if(min_num > num) min_num = num;
        int answer = max_num * min_num;
        System.out.println(answer);
    }
}
