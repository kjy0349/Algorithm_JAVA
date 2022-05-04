package Programmers;
import java.util.*;
public class String_Compress {
    class Solution {
        public int solution(String s) {
            if (s.length() == 1) return 1;
            int answer = 2147483647;
            StringBuilder sb = new StringBuilder();
            for (int i = 1;i <= s.length() / 2 + 1;i++) {
                sb = new StringBuilder();
                String a = s.substring(0, i);
                String b = "";
                int j = i;
                int count = 1;
                while (j + i <= s.length()){
                    b = s.substring(j, j + i);
                    if (!a.equals(b) && count == 1) {
                        sb.append(a);
                        a = new String(b);
                    } else if (!a.equals(b) && count > 0) {
                        sb.append(count).append(a);
                        a = new String(b);
                        count = 1;
                    } else count++;
                    j += i;
                }
                if (count > 1) sb.append(count).append(a);
                else sb.append(b);
                if (!b.equals(""))sb.append(s.substring(j));
                if (answer > sb.length() && sb.length() != 0) answer = sb.length();
            }
            return answer;
        }
    }
}
