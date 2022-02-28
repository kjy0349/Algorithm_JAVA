package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Paper_piece_conv {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int[][] paper = new int[N][M];
        int sub_sum;
        int temp_sum;
        int sub_index;
        int[] temp;
        for (int i = 0;i < N;i++){
            temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(temp, 0, paper[i], 0, M);
        }
        for (int i = 0;i < (1 << (N * M));i++){ // 가로 성분은 1, 세로 성분은 0
            sub_sum = 0;
            for (int j = 0;j < N;j++){
                temp_sum = 0;
                for (int k = 0;k < M;k++){
                    sub_index = j * M + k; // 비트 계산용 sub index
                    if ((i & (1 << sub_index)) == 0){
                        temp_sum = temp_sum * 10 + paper[j][k];
                    } else {
                        sub_sum += temp_sum;
                        temp_sum = 0;
                    }
                }
                sub_sum += temp_sum;
            }
            for (int k = 0;k < M;k++){
                temp_sum = 0;
                for (int j = 0;j < N;j++){
                    sub_index = j * M + k;
                    if ((i & (1 << sub_index)) != 0){
                        temp_sum = temp_sum * 10 + paper[j][k];
                    } else {
                        sub_sum += temp_sum;
                        temp_sum = 0;
                    }
                }
                sub_sum += temp_sum;
            }
            answer = Math.max(answer, sub_sum);
        }
        System.out.println(answer);
    }
}
