package backjoon;
import java.io.*;
import java.util.*;
public class Tetromino_fast {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0]; int M = inputs[1];
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = 0;
        int temp = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp = map[i][j];
                // 막대 - 1
                if(i+3 < N){
                    temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    if (temp > answer) answer = temp;
                }
                // 막대 - 2
                if(j+3 < M){
                    temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    if (temp > answer) answer = temp;
                }
                // 박스
                if(i+1 < N && j+1 < M){
                    temp = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㄴ - 1
                // ㄴ - 2
                if(j+1 < M && i+2 < N){
                    temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    if (temp > answer) answer = temp;
                    temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㄴ - 3
                // ㄴ - 4
                if(i-2 >= 0 && j+1 < M){
                    temp = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-2][j+1];
                    if (temp > answer) answer = temp;
                    temp = map[i][j] + map[i-1][j] + map[i-2][j] + map[i-2][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㄴ - 5
                // ㄴ - 6
                if(i-1 >= 0 && j+2 < M){
                    temp = map[i][j] + map[i-1][j] + map[i-1][j+1] + map[i-1][j+2];
                    if (temp > answer) answer = temp;
                }
                if(i-1 >= 0 && j-2 >= 0){
                    temp = map[i][j] + map[i-1][j] + map[i-1][j-1] + map[i-1][j-2];
                    if (temp > answer) answer = temp;
                }
                // ㄴ - 7
                if(i-1 >= 0 && j+2 < M){
                    temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+2];
                    if (temp > answer) answer = temp;
                }
                // ㄴ - 8
                if(i+1 < N && j+2 < M){
                    temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    if (temp > answer) answer = temp;
                }
                // ㄹ - 1
                if (i+2 < N && j+1 < M){
                    temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㄹ - 2
                if(i-1 >= 0 && j+2 < M){
                    temp = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-1][j+2];
                    if (temp > answer) answer = temp;
                }
                // ㄹ - 3
                if(i+1 < N && j+2 < M){
                    temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    if (temp > answer) answer = temp;
                }
                // ㄹ - 4
                if(i-2 >= 0 && j+1 < M){
                    temp = map[i][j] + map[i-1][j] + map[i-1][j+1] + map[i-2][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㅗ - 1
                if(i+1 < N && j+2 < M){
                    temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
                    if (temp > answer) answer = temp;
                }
                // ㅗ - 2
                if(i+2 < N && j+1 < M){
                    temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    if (temp > answer) answer = temp;
                }
                // ㅗ - 3
                if(i-1 >= 0 && j+2 < M){
                    temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+1];
                    if (temp > answer) answer = temp;
                }
                // ㅗ - 4
                if(i+2 < N && j-1 >= 0){
                    temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1];
                    if (temp > answer) answer = temp;
                }
            }
        }
        System.out.println(answer);
    }
}
