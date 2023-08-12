import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int target = (1 << 10) - 1; // 모든 숫자가 등장했을 때의 값
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            int t = 0; // N씩 더해가며 연산해야하므로 N을 유지해야 함. 따라서 대신 t로 사용
            int subBit = 0;
            do {
                t += N;
                String elem = Integer.toString(t); // 각 자릿수를 하나씩 뽑기위해 String으로 변환
                for (int i = 0; i < elem.length(); i++) {
                    int bit = elem.charAt(i) - '0';
                    subBit |= (1 << bit); // 각 자릿수에 해당하는 bit를 1로 변경
                }
            } while (target != subBit); // 모든 bit가 1인지 target과 비교
            sb.append("#").append(test).append(" ").append(t).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}