package HaRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'textQueries' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentences
     *  2. STRING_ARRAY queries
     */

    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {
        // Write your code here
        StringTokenizer st;
        final List<List<Integer>> ret_arr = new ArrayList<>(); // return
        final List<HashSet<String>> sens = new ArrayList<>(); // sentences's word
        final List<String> words = new ArrayList<>();
        for (int i = 0; i < sentences.size(); i++) { // 10000
            sens.add(new HashSet<>());
            st = new StringTokenizer(sentences.get(i).trim()); // 110
            final HashSet<String> elem = sens.get(i);
            while (st.hasMoreTokens()) elem.add(st.nextToken()); // 10
        }
        for (int i = 0; i < queries.size(); i++) { // 10000
            ret_arr.add(new ArrayList<>());
            st = new StringTokenizer(queries.get(i).trim());
            words.clear();
            while (st.hasMoreTokens()) words.add(st.nextToken());
            int count = 0;
            boolean poss = false;
            for (int j = 0; j < sens.size(); j++) { // 10
                if (count >= 10) {
                    poss = true;
                    break;
                }
                boolean is_inc = true;
                for (final String elem : words) { // 10
                    if (!sens.get(j).contains(elem)) {
                        is_inc = false;
                        break;
                    }
                }
                if (is_inc) {
                    ret_arr.get(i).add(j);
                    poss = true;
                    count++;
                }
            }
            if (!poss) ret_arr.get(i).add(-1);
        }
        return ret_arr;
    }

}

public class SimpleTextQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sentencesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> sentences = IntStream.range(0, sentencesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<List<Integer>> result = Result1.textQueries(sentences, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
