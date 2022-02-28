package backjoon;
import java.io.*;
import java.util.*;

public class Paper_piece {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> paper = new ArrayList<>();
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int sub_sum;
        int temp_sum;
        int sub_index;
        boolean find;
        int[] temp;
        for (int i = 0;i < N;i++){
            temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int elem : temp) paper.add(elem);
        }
        for (int i = 0;i < (1 << paper.size());i++){ // 가로 성분은 1, 세로 성분은 0
            sub_sum = 0;
            int j = 0;
            while (j < paper.size()){
                find = false;
                if ((i & (1 << j)) != 0){ // 가로 성분 찾았을 때
                    find = true;
                    temp_sum = paper.get(j);
                    sub_index = j % M + 1;
                    j++;
                    while ((i & (1 << j)) != 0 && sub_index < M){
                        temp_sum *= 10;
                        temp_sum += paper.get(j);
                        j++;
                        sub_index++;
                    }
                    sub_sum += temp_sum;
                }
                if (!find) j++;
            }
            j = 0;
            while (j < M){
                sub_index = j;
                while (sub_index < N * M){
                    find = false;
                    if ((i & (1 << sub_index)) == 0){
                        find = true;
                        temp_sum = paper.get(sub_index);
                        sub_index += M;
                        while ((i & (1 << sub_index)) == 0 && sub_index < N * M){
                            temp_sum = temp_sum * 10 + paper.get(sub_index);
                            sub_index += M;
                        }
                        sub_sum += temp_sum;
                    }
                    if (!find ) sub_index += M;
                }
                j++;
            }
            if (sub_sum > answer) answer = sub_sum;
        }
        System.out.println(answer);
    }
}