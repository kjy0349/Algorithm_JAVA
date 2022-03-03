package backjoon;
import java.io.*;
import java.util.*;

public class Longest_increasing_subsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> num = new TreeSet<>();
        for (int elem : number) num.add(elem);
        System.out.println(num.size());
    }
}
