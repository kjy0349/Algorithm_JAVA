package HaRank;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result3 {

    /*
     * Complete the 'getLargestNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING num as parameter.
     */

    public static boolean get_parity(int elem) {
        if (elem == 0) return false;
        else if (elem % 2 == 0) return false;
        else return true;
    }

    // 1806579
    public static String getLargestNumber(String num) {
        // Write your code here
        char[] st = num.toCharArray();
        boolean pre = get_parity(num.charAt(0) - '0');
        int con = 1;
        for (int i = 1; i < num.length(); i++) {
            boolean tar = get_parity(num.charAt(i) - '0');
            if (pre == tar) con++;
            else if (con >= 2){ // i - con ~ i - 1
                Arrays.sort(st, i - con, i);
                char[] clone = Arrays.copyOfRange(st, i - con, i);
                for (int j = 0; j < con; j++) {
                    st[i - con + j] = clone[clone.length - 1 - j];
                }
                con = 1;
                pre = get_parity(num.charAt(i) - '0');
            } else {
                con = 1;
                pre = get_parity(num.charAt(i) - '0');
            };
        }
        if (con >= 2) {
            Arrays.sort(st, st.length - con, st.length);
            char[] clone = Arrays.copyOfRange(st, st.length - con, st.length);
            for (int j = 0; j < con; j++) {
                st[st.length - con + j] = clone[clone.length - 1 - j];
            }
        }
        return String.valueOf(st);
    }

}

public class SwapParity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String num = bufferedReader.readLine();

        String result = Result3.getLargestNumber(num);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

