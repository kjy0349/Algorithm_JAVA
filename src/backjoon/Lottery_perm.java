package backjoon;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Lottery_perm {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] output = new int[6];
    public static void solve(int start, int count, int[] numbers) throws IOException{
        if (count == 6){
            for (int i = 0;i < output.length;i++){
                if (i < output.length - 1) bw.write(output[i] + " ");
                else bw.write(output[i] + "\n");
            }
        } else {
            for (int i = start;i < numbers.length;i++){
                output[count] = numbers[i];
                solve(i + 1, count + 1, numbers);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int[] temp;
        int[] numbers;
        while (scan.hasNext()){
            temp = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            numbers = new int[temp.length - 1];
            System.arraycopy(temp, 1, numbers, 0, numbers.length);
            solve(0,0, numbers);
            bw.newLine();
            bw.flush();
        }
    }
}
