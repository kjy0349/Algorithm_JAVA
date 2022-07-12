package HaRank;

import java.io.*;

import static java.util.stream.Collectors.joining;


class result {

    /*
     * Complete the 'compressWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING word
     *  2. INTEGER k
     */

    public static String compressWord(String word, int k) {
        // Write your code here
        char[] arr = word.toCharArray();
        while (true) {
            boolean is_exe = false;
            int con = 0;
            char pre = 'Z';
            for (int i = 0; i < word.length(); i++) {
                if (pre != arr[i]) {
                    if (arr[i] != 0) {
                        pre = arr[i];
                        con = 1;
                    }
                } else if (arr[i] != 0) con++;
                if (con == k) {
                    int count = 0;
                    int index = i;
                    while (count < k && index >= 0) {
                        if (arr[index] == pre) {
                            arr[index] = 0;
                            count++;
                        }
                        else index--;
                    }
                    is_exe = true;
                    con = 0;
                }
            }
            if (!is_exe) break;
        }
        StringBuilder sb = new StringBuilder();
        for (char elem : arr) {
            if (elem != 0) sb.append(elem);
        }
        return sb.toString();
    }

}

public class WordCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = HaRank.result.compressWord(word, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

