package backjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2290 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String number = st.nextToken();
        int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0;i < 2 * s + 3;i++) {
            StringBuilder sb = new StringBuilder();
            for (int value : numbers) {
                for (int j = 0; j < s + 2; j++) {
                    boolean b = j != 0 && j != s + 1 && i % (s + 1) == 0; // 중간 짝대기 2개
                    switch (value) {
                        case 1:
                            if (j == s + 1 && i % (s + 1) != 0) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 2:
                            if (b) sb.append("-");
                            else if ((j == s + 1 && i >= 1 && i <= s) || (j == 0 && (i >= s + 2  && i < 2 * s + 2))) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 3:
                            if (b) sb.append("-");
                            else if ((j == s + 1 && i % (s + 1) != 0)) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 4:
                            if (i >= 1 && i <= s && j == 0) sb.append("|");
                            else if ((j == s + 1 && i % (s + 1) != 0)) sb.append("|");
                            else if (j != 0 && j != s + 1 && i == s + 1) sb.append("-");
                            else sb.append(" ");
                            break;
                        case 5:
                            if (b) sb.append("-");
                            else if ((i >= 1 && i <= s && j == 0) || (j == s + 1 && (i >= s + 2  && i < 2 * s + 2))) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 6:
                            if ((j == 0 && i % (s + 1) != 0)) sb.append("|");
                            else if (b) sb.append("-");
                            else if ((j == s + 1 && (i >= s + 2  && i < 2 * s + 2))) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 7:
                            if ((j == s + 1 && i % (s + 1) != 0)) sb.append("|");
                            else if (j % (s + 1) != 0 && i == 0) sb.append("-");
                            else sb.append(" ");
                            break;
                        case 8:
                            if (b) sb.append("-");
                            else if (i % (s + 1) != 0 && (j == 0 || j == s + 1)) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 9:
                            if (b) sb.append("-");
                            else if ((j == s + 1 && i % (s + 1) != 0)) sb.append("|");
                            else if (j == 0 && i >= 1 && i < s + 1) sb.append("|");
                            else sb.append(" ");
                            break;
                        case 0:
                            if ((j == 0 || j == s + 1) && i % (s + 1) != 0) sb.append("|");
                            else if ((i == 0 || i == 2 * s + 2) && j % (s + 1) != 0) sb.append("-");
                            else sb.append(" ");
                            break;
                        default:
                            sb.append(" ");
                    }
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
