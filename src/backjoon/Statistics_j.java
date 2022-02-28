package backjoon;
import java.io.*;
import java.util.Arrays;

public class Statistics_j {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int al_average = 0;
        int middle = 0;
        int most_reveal = 0;
        int range = 0;
        int max_num = -2147483648;
        int min_num = 2147483647;

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        int sub_sum = 0;
        for (int i = 0;i < N;i++){
            number[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0;i < N;i++){
            sub_sum += number[i];
        }
        al_average = sub_sum / N;
        middle = number[N / 2];
        for (int elem : number){
            max_num = Math.max(elem, max_num);
            min_num = Math.min(elem, min_num);
        }
        Arrays.sort(number);
        range = Math.abs(max_num - min_num);
        int length = 1;
        int sub_length = 1;
        int temp;
        temp = number[0];
        int count = 0;
        for (int i = 1;i < N;i++){
            if (temp == number[i]) sub_length++;
            else {
                temp = number[i];
                length = Math.max(sub_length, length);
                count++;
            }
        }

        System.out.println(al_average);
        System.out.println(middle);
        System.out.println(al_average);
        System.out.println(range);
    }
}
