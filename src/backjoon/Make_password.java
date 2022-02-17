package backjoon;
import java.io.*;
import java.util.*;

public class Make_password {
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
    static void solve(int count, int start, String[] alp, int L, char[] possible){
        if (count == L){
            int vowel_count = 0; // 모음 개수
            int consonant_count = 0; // 자음 개수
            boolean is_vowel; // 모음인가?
            for(char alphabet : possible){ // possible 배열에서 해당 경우에대한 문자들을 하나씩 가져옴
                is_vowel = false;
                for (int j = 0;j < 5;j++){ // 미리 만들어둔 모음 배열의 알파벳들과 하나씩 비교하면서 모음인지 검사함
                    if (alphabet == vowels[j]){
                        vowel_count++; // 모음일 경우 모음 개수 1증가
                        is_vowel = true; // 끝나고 자음인지 알아보기 위해 true로 값 변경
                        break ;
                    }
                }
                if (!is_vowel) consonant_count++;
            }
            if (consonant_count >= 2 && vowel_count >= 1){ // 출력 부분
                sb.append(possible).append("\n");
            }
        } else{
            for (int i = start;i < alp.length;i++){
                possible[count] = alp[i].toCharArray()[0]; // 좋은 코드인가?..
                solve(count + 1, i + 1, alp, L, possible);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int L = inputs[0];
        int C = inputs[1]; // 안 씀, alp의 길이
        String[] alp = br.readLine().split(" ");
        Arrays.sort(alp);
        char[] possible = new char[L];
        solve(0, 0, alp, L, possible);
        System.out.print(sb);
    }
}
